package com.example

import com.google.inject.Stage
import com.twitter.finatra.http.EmbeddedHttpServer
import log.rest.ExampleServer
import org.scalatest.FunSuite

class ExampleStartupTest extends FunSuite {

  lazy val server = new EmbeddedHttpServer(
    stage = Stage.PRODUCTION,
    twitterServer = new ExampleServer)

  test("Server#startup") {
    try {
      server.assertHealthy()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
