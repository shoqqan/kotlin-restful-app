package dev.shoqqan.todo.kotlin_todo.users

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/users")
class UserController(
    @Autowired private val userRepository: UserRepository,
) {
    // get all users
    @GetMapping("")
    fun getAllUsers(): List<User> = userRepository.findAll().toList()

    // create user
    @PostMapping("")
    fun createUser(
        @RequestBody user: User,
    ): ResponseEntity<User> {
        val savedUser = userRepository.save(user)
        return ResponseEntity(savedUser, HttpStatus.CREATED)
    }

    // get user by id
    @GetMapping("/{id}")
    fun getUserById(
        @PathVariable("id") id: UUID,
    ): ResponseEntity<User> {
        val user = userRepository.findById(id)
        return if (user != null) {
            ResponseEntity(user.get(), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    // update user
    @PutMapping("/{id}")
    fun updateUserById(
        @PathVariable("id") id: UUID,
        @RequestBody user: User,
    ): ResponseEntity<User> =
        if (userRepository.existsById(id)) {
            val updatedUser = userRepository.save(user.copy(id = id))
            ResponseEntity(updatedUser, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }

    // delete user
    @DeleteMapping("/{id}")
    fun deleteUserById(
        @PathVariable("id") id: UUID,
    ): ResponseEntity<Void> =
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
}
