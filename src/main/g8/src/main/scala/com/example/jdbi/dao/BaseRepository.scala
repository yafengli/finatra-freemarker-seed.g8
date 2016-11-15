package com.example.jdbi.dao

import java.util

trait BaseRepository[T] {
  def createTable(): Unit

  def save(d: T): Unit

  def delete(d: T): Unit

  def update(d: T): Unit

  def findAll(): util.List[T]

  def findById(id: Long): T

  def count(): Long
}
