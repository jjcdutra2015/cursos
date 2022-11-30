package jjcdutra2015.com.github.service

import jjcdutra2015.com.github.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class UserService(
    private val repository: UserRepository
) : UserDetailsService {

    private val logger = Logger.getLogger(UserService::class.java.name)

    override fun loadUserByUsername(username: String?): UserDetails {
        logger.info("Find user by username $username")
        val user = repository.findByUsername(username)
        return user ?: throw UsernameNotFoundException("Username $username not found")
    }
}