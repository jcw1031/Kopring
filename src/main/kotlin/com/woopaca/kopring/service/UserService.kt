package com.woopaca.kopring.service

import com.woopaca.kopring.dto.SignUpRequestDto

interface UserService {

    fun join(signUpRequestDto: SignUpRequestDto)
}