package com.example.jdbi.dao

import java.util

import com.example.jdbi.mapper.{Something, SomethingMapper}
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper
import org.skife.jdbi.v2.sqlobject.{Bind, BindBean, SqlQuery, SqlUpdate}

@RegisterMapper(Array(classOf[SomethingMapper]))
trait SomethingRepository extends BaseRepository[Something] {
  @SqlUpdate("insert into t_something(id,name) values(:id, :name)")
  override def save(@BindBean d: Something)

  @SqlUpdate("delete from t_something where id=:id")
  override def delete(d: Something): Unit

  @SqlUpdate("update t_something set name=:name where id=:id")
  override def update(d: Something): Unit

  @SqlQuery("select * from t_something")
  override def findAll(): util.List[Something]

  @SqlQuery("select * from t_something where id = :id")
  override def findById(@Bind("id") id: Long): Something

  @SqlQuery("select count(*) from t_something")
  override def count(): Long

  @SqlUpdate("create or replace table t_something (id int primary key, name varchar(100))")
  override def createTable(): Unit
}
