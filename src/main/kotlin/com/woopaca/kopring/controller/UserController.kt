package com.woopaca.kopring.controller

import com.woopaca.kopring.dto.SignUpRequestDto
import com.woopaca.kopring.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val userService: UserService) {

    @PostMapping("/api/v1/sign-up")
    fun signUp(@RequestBody signUpRequestDto: SignUpRequestDto): ResponseEntity<String> {
        userService.join(signUpRequestDto)
        return ResponseEntity.ok().body("Welcome!")
    }
}