package com.example.jdbi.mapper

import java.sql.ResultSet

import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import scala.beans.BeanProperty

case class Something(@BeanProperty id: Int, @BeanProperty name: String)

class SomethingMapper extends ResultSetMapper[Something] {
  override def map(index: Int, r: ResultSet, ctx: StatementContext): Something = {
    Something(r.getInt("id"), r.getString("name"))
  }
}
