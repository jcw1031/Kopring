package com.woopaca.kopring.service.impl

import com.woopaca.kopring.domain.User
import com.woopaca.kopring.dto.SignInRequestDto
import com.woopaca.kopring.dto.SignUpRequestDto
import com.woopaca.kopring.exception.DuplicateUsernameException
import com.woopaca.kopring.exception.UserNotFoundException
import com.woopaca.kopring.exception.UserPasswordIncorrectException
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

    override fun login(signInRequestDto: SignInRequestDto): String {
        val user = userRepository.findByUsername(signInRequestDto.username)
            .orElseThrow { throw UserNotFoundException("존재하지 않는 회원입니다.") }
        if (!user.password.equals(signInRequestDto.password)) {
            throw UserPasswordIncorrectException("비밀번호가 일치하지 않습니다.")
        }

        return user.name
    }
}