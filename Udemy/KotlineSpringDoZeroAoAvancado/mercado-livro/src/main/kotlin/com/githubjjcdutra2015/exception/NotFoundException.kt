package com.githubjjcdutra2015.exception

class NotFoundException(override val message: String, val errorCode: String) : Exception() {
}