package com.example

import com.google.inject.Stage
import com.twitter.finatra.http.EmbeddedHttpServer
import org.scalatest.FunSuite

class ExampleStartupTest extends FunSuite {

  lazy val server = new EmbeddedHttpServer(
    stage = Stage.PRODUCTION,
    twitterServer = new HelloServer)

  test("Server#startup") {
    try {
      server.assertHealthy()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
