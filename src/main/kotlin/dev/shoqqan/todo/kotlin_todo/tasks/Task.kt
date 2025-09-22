package dev.shoqqan.todo.kotlin_todo.tasks

import dev.shoqqan.todo.kotlin_todo.todolists.Todolist
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "tasks")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,
    val title: String,
    val isDone: Boolean = false,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todolist_id")
    val todolist: Todolist,
)
