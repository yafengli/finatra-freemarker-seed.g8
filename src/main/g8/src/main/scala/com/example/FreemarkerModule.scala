package com.example

import java.io.File
import javax.inject.Singleton

import com.example.freemarker.{Freemarker, FreemarkerBodyComponent, FreemarkerConfigurationFactory, FreemarkerMessageBodyWriter}
import com.google.inject.Provides
import com.twitter.finatra.http.internal.marshalling.MessageBodyManager
import com.twitter.finatra.http.modules.DocRootModule
import com.twitter.finatra.http.routing.FileResolver
import com.twitter.inject.annotations.Flag
import com.twitter.inject.{Injector, TwitterModule}

object FreemarkerModule extends TwitterModule {
  private val templatesDir = flag("freemarker.templates.dir", "templates", "templates resource directory")

  override def modules = Seq(DocRootModule)

  @Provides
  @Singleton
  def provideFreemarkerFactory(resolver: FileResolver, @Flag("local.doc.root") localDocRoot: String): FreemarkerConfigurationFactory = {
    val factory = new FreemarkerConfigurationFactory()
    localDocRoot match {
      case s: String if s != null && s.trim.length > 0 => factory.configuration.setDirectoryForTemplateLoading(new File(new File(localDocRoot), templatesDir()))
      case _ => factory.configuration.setClassLoaderForTemplateLoading(this.getClass.getClassLoader, templatesDir())
    }
    factory
  }

  override def singletonStartup(injector: Injector) {
    val manager = injector.instance[MessageBodyManager]
    manager.addByAnnotation[Freemarker, FreemarkerMessageBodyWriter]()
    manager.addByComponentType[FreemarkerBodyComponent, FreemarkerMessageBodyWriter]()
  }
}
