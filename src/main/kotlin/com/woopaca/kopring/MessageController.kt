package com.woopaca.kopring

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController(val messageService: MessageService) {

    @GetMapping("/start")
    fun index(@RequestParam("name") name: String) = listOf(
        Message("1", "Hello! $name"),
        Message("2", "Bonjour! $name"),
        Message("3", "Privet! $name")
    )

    @GetMapping
    fun findAll(): List<Message> = messageService.findMessages()

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: String): Message = messageService.findMessageById(id)

    @PostMapping
    fun post(@RequestBody message: Message) {
        messageService.save(message)
    }
}