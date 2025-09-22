package dev.shoqqan.todo.kotlin_todo.todolists

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TodolistRepository : CrudRepository<Todolist, UUID>
