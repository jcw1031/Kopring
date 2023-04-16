package com.woopaca.kopring.service.impl

import com.woopaca.kopring.domain.User
import com.woopaca.kopring.dto.SignUpRequestDto
import com.woopaca.kopring.exception.DuplicateUsernameException
import com.woopaca.kopring.repository.UserRepository
import com.woopaca.kopring.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {

    override fun join(signUpRequestDto: SignUpRequestDto) {
        userRepository.findByUsername(signUpRequestDto.username)
            .ifPresent { throw DuplicateUsernameException("중복된 회원 아이디입니다.") }
        val user = User(
            null, signUpRequestDto.username, signUpRequestDto.password,
            signUpRequestDto.name
        )
        userRepository.save(user)
    }
}