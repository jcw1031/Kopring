package com.woopaca.kopring

import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(val messageRepository: MessageRepository) {

    fun findMessages(): List<Message> = messageRepository.findAll().toList()

    fun findMessageById(id: String): Message = messageRepository.findById(id).get()

    fun save(message: Message) {
        messageRepository.save(message)
    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) {
            listOf(get())
        } else {
            emptyList()
        }
}