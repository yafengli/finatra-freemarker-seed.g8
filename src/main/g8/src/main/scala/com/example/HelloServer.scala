package com.example

import com.example.http._
import com.google.inject.Module
import com.twitter.finagle.http.{Request, Response}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{CommonFilters, LoggingMDCFilter, TraceIdMDCFilter}
import com.twitter.finatra.http.routing.HttpRouter
import finatra.freemarker.FreemarkerModule

object HelloServerMain extends HelloServer

class HelloServer extends HttpServer {
  override def defaultFinatraHttpPort = ":80"

  override protected def modules: Seq[Module] = Array(FreemarkerModule,H2Module)

  override def configureHttp(router: HttpRouter): Unit = {
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]
      .add[HomeController]
  }
}