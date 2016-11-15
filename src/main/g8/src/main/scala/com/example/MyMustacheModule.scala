package com.example

import java.io._
import javax.inject.Singleton

import com.github.mustachejava.{DefaultMustacheFactory, Mustache, MustacheFactory}
import com.google.inject.Provides
import com.twitter.finatra.http.internal.marshalling.mustache.ScalaObjectHandler
import com.twitter.finatra.http.modules.DocRootModule
import com.twitter.finatra.http.routing.FileResolver
import com.twitter.inject.TwitterModule
import com.twitter.inject.annotations.Flag

object MyMustacheModule extends TwitterModule {

  val defaultSuffix = ".mustache"
  private val templatesDir = flag("mustache.templates.dir", "templates", "templates resource directory")
  private val templatesSuffix = flag("mustache.templates.suffix", ".mustache", "templates suffix.")

  override def modules = Seq(DocRootModule)

  @Provides
  @Singleton
  def provideMustacheFactory(resolver: FileResolver, @Flag("local.doc.root") localDocRoot: String): MustacheFactory = {
    val cacheMustacheTemplates = localDocRoot.isEmpty
    val templatesDirectory = templatesDir()

    new DefaultMustacheFactory(templatesDirectory) {
      setObjectHandler(new ScalaObjectHandler)

      override def compile(name: String): Mustache = {
        val nameToUse = templatesSuffix.get match {
          case Some(s) => name.stripSuffix(defaultSuffix) + s
          case None => name
        }
        if (cacheMustacheTemplates) {
          super.compile(nameToUse)
        } else {
          new LocalFilesystemDefaultMustacheFactory(templatesDirectory, resolver).compile(nameToUse)
        }
      }
    }
  }

}

/**
  * A local filesystem-only MustacheFactory. Uses the FileResolver for resolution and
  * does not internally cache templates.
  */
private final class LocalFilesystemDefaultMustacheFactory(
                                                           templatesDirectory: String,
                                                           resolver: FileResolver)
  extends DefaultMustacheFactory {
  setObjectHandler(new ScalaObjectHandler)

  override def getReader(resourceName: String): Reader = {
    // Relative paths are prefixed by the templates directory.
    val filepath = if (resourceName.startsWith("/")) {
      resourceName
    } else if (templatesDirectory.startsWith("/")) {
      templatesDirectory+"/"+resourceName
    } else {
      templatesDirectory+"/"+resourceName
    }

    (resolver.getInputStream(filepath) map { inputStream: InputStream =>
      new InputStreamReader(inputStream)
    }).getOrElse(throw new FileNotFoundException("Unable to find file: "+filepath))
  }
}