package com.githubjjcdutra2015.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("admin")
class AdminController {

    @GetMapping("/reports")
    fun report(): String {
        return "This is a Report. Only admin can see it!"
    }
}