package io.github.shiniseong.willofember

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform