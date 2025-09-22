
package dev.shoqqan.todo.kotlin_todo.todolists

import dev.shoqqan.todo.kotlin_todo.tasks.Task
import dev.shoqqan.todo.kotlin_todo.users.User
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "todolists")
data class Todolist(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,
    val title: String,
    @OneToMany(mappedBy = "todolist", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val tasks: List<Task> = emptyList(),
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,
)
