package dev.shoqqan.todo.kotlin_todo.tasks

import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/tasks")
class TaskController(
    private val taskRepository: TaskRepository,
) {
    @GetMapping
    fun getAllTasks(): Iterable<Task> = taskRepository.findAll()

    @GetMapping("/{id}")
    fun getTaskById(
        @PathVariable id: UUID,
    ): Task? = taskRepository.findById(id).orElse(null)

    @PostMapping
    fun createTask(
        @RequestBody task: Task,
    ): Task = taskRepository.save(task)

    @PutMapping("/{id}")
    fun updateTask(
        @PathVariable id: UUID,
        @RequestBody task: Task,
    ): Task = taskRepository.save(task.copy(id = id))

    @DeleteMapping("/{id}")
    fun deleteTask(
        @PathVariable id: UUID,
    ) = taskRepository.deleteById(id)
}
