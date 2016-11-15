package com.example.jdbi.mapper

import java.sql.ResultSet

import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

case class User(id: Long, username: String, password: String, age: Int, address: String)

class UserMapper extends ResultSetMapper[User] {
  override def map(index: Int, r: ResultSet, ctx: StatementContext): User = {
    User(r.getLong("id"), r.getString("username"), r.getString("password"), r.getInt("age"), r.getString("address"))
  }
}

