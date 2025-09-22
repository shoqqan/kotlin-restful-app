package dev.shoqqan.todo.kotlin_todo.users

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int> {

}