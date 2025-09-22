@file:Suppress("ktlint:standard:no-wildcard-imports")

package dev.shoqqan.todo.kotlin_todo.users
import dev.shoqqan.todo.kotlin_todo.todolists.Todolist
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,
    val name: String,
    val email: String,
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val todolists: List<Todolist> = emptyList(),
)
