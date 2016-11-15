package com.example.jdbi

import javax.inject.{Inject, Singleton}

import org.skife.jdbi.v2.{DBI, Handle}

import scala.reflect.{ClassTag, _}

@Singleton
class DbiWrapper @Inject()(dbi: DBI) {
  def withHandle(call: Handle => Any) = {
    val handle = dbi.open()
    var result = null.asInstanceOf[Any]
    try {
      result = call(handle)
    } catch {
      case e: Exception => e.printStackTrace()
    }
    finally {
      handle.close()
    }
    result
  }

  def withRepo[SqlObjectType: ClassTag](call: SqlObjectType => Any): Any = {
    withHandle { h =>
      val repo = h.attach(classTag[SqlObjectType].runtimeClass).asInstanceOf[SqlObjectType]
      call(repo)
    }
  }
}
