package com.woopaca.kopring

import org.springframework.data.annotation.Id
import javax.persistence.Table

@Table(name = "messages")
data class Message(@Id val id: String?, val text: String)