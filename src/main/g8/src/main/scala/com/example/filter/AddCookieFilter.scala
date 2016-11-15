package com.example.filter

import com.twitter.finagle.http.{Request, Response}
import com.twitter.finagle.{Service, SimpleFilter}
import com.twitter.util.Future

/**
  * Created by YaFengLi on 2016/10/24.
  */
class AddCookieFilter extends SimpleFilter[Request, Response] {
  override def apply(request: Request, service: Service[Request, Response]): Future[Response] = {
    trace(request)    
    service(request)
  }

  private def trace(request: Request): Unit = {
    println(s"---------Query Parameters:${request.params.size}"---------
    request.params.foreach { t => println(s"${t._1}:${t._2}") }
    println(s"---------Request Cookies:${request.cookies.size}---------")
    request.cookies.foreach { t => println(s"${t._1}:${t._2.value}") }
    println(s"---------Response Cookies:${request.response.cookies.size}---------")
    request.response.cookies.foreach { t => println(s"${t._1}:${t._2.value}") }
    println("-----------------------------------------------")
  }
}
