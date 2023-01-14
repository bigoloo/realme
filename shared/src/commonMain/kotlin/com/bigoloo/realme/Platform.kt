package com.bigoloo.realme

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform