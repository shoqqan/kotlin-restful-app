package dev.shoqqan.todo.kotlin_todo.users

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository : CrudRepository<User, UUID>
