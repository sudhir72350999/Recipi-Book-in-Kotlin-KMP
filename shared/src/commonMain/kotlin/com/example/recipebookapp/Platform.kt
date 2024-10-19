package com.example.recipebookapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform