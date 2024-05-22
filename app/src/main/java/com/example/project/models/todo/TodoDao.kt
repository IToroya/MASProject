package com.example.project.models.todo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun getAll(): List<Todo>

    @Query("SELECT * FROM todo WHERE uid IN (:todoIds)")
    fun loadAllByIds(todoIds: IntArray): List<Todo>

    @Query("SELECT * FROM todo WHERE title LIKE :title LIMIT 1")
    fun findByName(title: String): Todo

    @Insert
    fun insertAll(vararg todo: Todo)

    @Delete
    fun delete(todo: Todo)
}