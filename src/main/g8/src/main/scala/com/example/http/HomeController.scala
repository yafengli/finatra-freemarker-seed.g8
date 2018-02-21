package com.example.http

import java.io._
import javax.inject.{Inject, Singleton}

import com.example.service.ExampleService
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.finatra.http.request.RequestUtils
import finatra.freemarker.FreemarkerConfigurationFactory
import finatra.views.freemarker.Freemarker

@Singleton
class HomeController @Inject()(service: ExampleService, freemarkerConfigurationFactory: FreemarkerConfigurationFactory) extends Controller {

  get("/") { _: Request =>
    DemoView("YaFengLi", List(Person("test_1", 1), Person("test_2", 2), Person("test_3", 3)))
  }

  post("/upload") { request: Request =>
    RequestUtils.multiParams(request).filter(_._1 == "file").headOption.fold(response.notFound) { t =>
      val fn = t._2.filename.get
      val n_fn = RequestUtils.multiParams(request).filter(_._1 == "name").headOption.fold(fn)(j => new String(j._2.data))
      val file = new File(fn)
      val out = new BufferedOutputStream(new FileOutputStream(file))
      try out.write(t._2.data)
      finally {
        out.flush()
        out.close()
      }
      response.ok.header("content-disposition", "attachment; filename='" + n_fn + ".txt'").file(file)
    }
}

@Freemarker("demo")
case class DemoView(name: String, persons: List[Person])

case class Person(name: String, age: Int)
