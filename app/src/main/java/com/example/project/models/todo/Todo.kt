package com.example.project.models.todo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class Todo(
  @PrimaryKey(autoGenerate = true) val uid: Int,
  val title: String?,
  val description: String?,
  val finished: Boolean?,
  val favourite: Boolean?,
  val dueDate: LocalDate?
)