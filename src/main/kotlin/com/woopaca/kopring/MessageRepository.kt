package com.woopaca.kopring

import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, Long> {
}