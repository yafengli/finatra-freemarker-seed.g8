package com.example

import com.twitter.finagle.http.Status._
import com.twitter.finatra.http.EmbeddedHttpServer
import org.scalatest.FunSuite

class ExampleFeatureTest extends FunSuite {

  lazy val server = new EmbeddedHttpServer(new HelloServer)
  test("Server#ping") {
    try {
      server.httpGet(
        path = "/ping",
        andExpect = Ok,
        withBody = "pong")
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
