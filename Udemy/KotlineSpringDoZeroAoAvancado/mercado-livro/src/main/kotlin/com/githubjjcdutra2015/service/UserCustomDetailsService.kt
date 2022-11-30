package com.githubjjcdutra2015.service

import com.githubjjcdutra2015.exception.AuthenticationException
import com.githubjjcdutra2015.repository.CustomerRepository
import com.githubjjcdutra2015.security.UserCustomDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserCustomDetailsService(
    private val customerRepository: CustomerRepository
) : UserDetailsService {
    override fun loadUserByUsername(id: String): UserDetails {
        val customer = customerRepository.findById(id.toInt())
            .orElseThrow { throw AuthenticationException("Usuario não encontrado", "ML123") }

        return UserCustomDetails(customer)
    }
}