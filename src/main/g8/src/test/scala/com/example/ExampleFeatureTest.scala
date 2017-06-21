package com.example

import com.twitter.finagle.http.Status._
import com.twitter.finatra.http.EmbeddedHttpServer
import log.rest.ExampleServer
import org.scalatest.FunSuite

class ExampleFeatureTest extends FunSuite {

  lazy val server = new EmbeddedHttpServer(new ExampleServer)
  test("Server#Say hi") {
    try {
      server.httpGet(
        path = "/log",
        andExpect = Ok,
        withBody = "pong")
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
