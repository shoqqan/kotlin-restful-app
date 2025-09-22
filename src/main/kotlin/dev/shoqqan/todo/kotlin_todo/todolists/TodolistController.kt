package dev.shoqqan.todo.kotlin_todo.todolists

import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/todolists")
class TodolistController(
    private val todolistRepository: TodolistRepository,
) {
    @GetMapping
    fun getAllTodolists(): Iterable<Todolist> = todolistRepository.findAll()

    @GetMapping("/{id}")
    fun getTodolistById(
        @PathVariable id: UUID,
    ): Todolist? = todolistRepository.findById(id).orElse(null)

    @PostMapping
    fun createTodolist(
        @RequestBody todolist: Todolist,
    ): Todolist = todolistRepository.save(todolist)

    @PutMapping("/{id}")
    fun updateTodolist(
        @PathVariable id: UUID,
        @RequestBody todolist: Todolist,
    ): Todolist = todolistRepository.save(todolist.copy(id = id))

    @DeleteMapping("/{id}")
    fun deleteTodolist(
        @PathVariable id: UUID,
    ) = todolistRepository.deleteById(id)
}
