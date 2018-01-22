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
    RequestUtils.multiParams(request).filter(_._1 == "file").headOption match {
      case Some(k) =>
        k._2.filename match {
          case Some(fn) =>
            val file = new File(fn)
            val out = new BufferedOutputStream(new FileOutputStream(file))
            try out.write(k._2.data)
            finally {
              out.flush()
              out.close()
            }
            response.ok.header("content-disposition","inline; filename='"+fn+".txt'").file(file)
          case None => response.notFound
        }
      case None => response.notFound
    }
  }
}

@Freemarker("demo")
case class DemoView(name: String, persons: List[Person])

case class Person(name: String, age: Int)
