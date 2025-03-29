package io.github.shiniseong.willofflame.shared.application.domain.vo.id

import io.github.shiniseong.willofember.shared.application.domain.vo.ValueObject
import kotlin.jvm.JvmInline

@JvmInline
value class UserId(override val value: String) : ValueObject<String> {
    init {
        require(value.isNotEmpty()) { "UserId value must not be empty" }
        require(value.length <= 50) { "UserId value must be at most 50 characters long" }
    }

    companion object {
        fun from(value: String): UserId {
            return UserId(value)
        }
    }
}
