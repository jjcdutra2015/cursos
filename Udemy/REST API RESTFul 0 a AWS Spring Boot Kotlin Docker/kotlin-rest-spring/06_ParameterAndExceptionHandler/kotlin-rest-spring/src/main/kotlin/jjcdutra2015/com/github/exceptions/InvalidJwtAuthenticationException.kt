package jjcdutra2015.com.github.exceptions

import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.FORBIDDEN)
class InvalidJwtAuthenticationException(message: String?) : AuthenticationException(message)