package io.github.shiniseong.willofflame.shared.application.domain.vo

import io.github.shiniseong.willofember.shared.application.domain.vo.ValueObject
import kotlin.jvm.JvmInline

@JvmInline
value class Nickname(override val value: String) : ValueObject<String> {
    init {
        require(value.isNotBlank()) { "Nickname cannot be blank" }
        require(value.length in 2..20) { "Nickname must be between 2 and 20 characters" }
    }
}