package dev.shoqqan.todo.kotlin_todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class KotlinTodoApplication

fun main(args: Array<String>) {
    runApplication<KotlinTodoApplication>(*args)
}
