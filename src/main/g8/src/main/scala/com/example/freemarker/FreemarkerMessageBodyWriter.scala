package com.example.freemarker

import java.util
import javax.inject.{Inject, Singleton}

import com.google.common.net.MediaType
import com.twitter.finatra.http.marshalling.{MessageBodyWriter, WriterResponse}

import scala.collection.JavaConverters._

@Singleton
class FreemarkerMessageBodyWriter @Inject()(freemarkerService: FreemarkerService,
                                            templateLookup: FreemarkerTemplateNameLookup)
  extends MessageBodyWriter[Any] {
  override def write(obj: Any): WriterResponse = {
    WriterResponse(
      MediaType.HTML_UTF_8,
      freemarkerService.createBuffer(
        templateLookup.getTemplateName(obj),
        transToJavaMap(obj)))
  }

  /* Private */
  private def transToJavaMap(obj: Any): util.Map[String, Any] = {
    (Map[String, Any]() /: obj.getClass.getDeclaredFields) { (a, f) =>
      f.setAccessible(true)
      a + (f.getName -> f.get(obj))
    } asJava
  }
}
