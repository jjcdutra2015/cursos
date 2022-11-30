package com.githubjjcdutra2015.exception

class AuthenticationException(override val message: String, val errorCode: String) : Exception()