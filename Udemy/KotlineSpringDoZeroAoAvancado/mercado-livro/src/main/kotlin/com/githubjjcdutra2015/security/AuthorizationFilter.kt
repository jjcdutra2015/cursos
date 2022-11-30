package com.githubjjcdutra2015.security

import com.githubjjcdutra2015.exception.AuthenticationException
import com.githubjjcdutra2015.service.UserCustomDetailsService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthorizationFilter(
    authenticationManager: AuthenticationManager,
    private val userCustomDetailsService: UserCustomDetailsService,
    private val jwtUtil: JwtUtil
) : BasicAuthenticationFilter(authenticationManager) {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val authorization = request.getHeader("Authorization")
        if (authorization != null && authorization.startsWith("Bearer ")) {
            val token = authorization.split(" ")[1]
            val auth = getAuthentication(token)
            SecurityContextHolder.getContext().authentication = auth
        }

        chain.doFilter(request, response)
    }

    private fun getAuthentication(token: String): UsernamePasswordAuthenticationToken {
        if (!jwtUtil.isValidToken(token)) {
            throw AuthenticationException("Token invalido", "ML123")
        }
        val subject = jwtUtil.getSubject(token)
        val customer = userCustomDetailsService.loadUserByUsername(subject)

        return UsernamePasswordAuthenticationToken(customer, null, customer.authorities)
    }
}
