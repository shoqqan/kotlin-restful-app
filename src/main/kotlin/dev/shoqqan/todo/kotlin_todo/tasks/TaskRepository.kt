package dev.shoqqan.todo.kotlin_todo.tasks

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TaskRepository : CrudRepository<Task, UUID>
