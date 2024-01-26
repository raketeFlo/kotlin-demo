package com.example.demo

import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(val db: MessageRepository) {
    fun findMessages(): List<Message> = db.findAll().toList()

    fun save(message: Message) {
        db.save(message)
    }

    fun findMessageById(id: String): List<Message> = db.findById(id).toList()

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}