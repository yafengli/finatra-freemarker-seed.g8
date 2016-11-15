package com.example

import com.example.jdbi.dao.{SomethingRepository, UserRepository}
import com.twitter.inject.{Injector, TwitterModule}
import org.h2.jdbcx.JdbcConnectionPool
import org.h2.tools.Server
import org.skife.jdbi.v2.tweak.HandleCallback
import org.skife.jdbi.v2.{DBI, Handle}


object H2Module extends TwitterModule {
  val server = Server.createTcpServer()
  val ds = JdbcConnectionPool.create("jdbc:h2:mem:test", "sa", "")
  val dbi = new DBI(ds)

  protected override def configure(): Unit = {
    dbi.withHandle(new HandleCallback[Unit] {
      override def withHandle(handle: Handle): Unit = {
        handle.attach(classOf[SomethingRepository]).createTable()
        handle.attach(classOf[UserRepository]).createTable()
      }
    })

    bind[DBI].toInstance(dbi)
  }

  override def singletonStartup(injector: Injector): Unit = {
    server.start()
  }

  override def singletonShutdown(injector: Injector): Unit = {
    server.shutdown()
  }
}
