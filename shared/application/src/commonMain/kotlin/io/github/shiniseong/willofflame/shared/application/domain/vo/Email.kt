package io.github.shiniseong.willofflame.shared.application.domain.vo

import io.github.shiniseong.willofember.shared.application.domain.vo.ValueObject
import kotlin.jvm.JvmInline

@JvmInline
data class Email(override val value: EmailValue) : ValueObject<EmailValue> {
    init {
        require(value.matches(emailRegex)) { "Invalid email format" }
    }

    val domain: String
        get() = value.substringBefore('@')

    val username: String
        get() = value.substringAfter('@')

    fun anonymized(): String = when {
        username.length <= 4 -> "${username.first()}***@$domain"
        username.length <= 6 -> "${username.take(2)}***${username.last()}@$domain"
        else -> "${username.take(3)}***${username.takeLast(2)}@$domain"
    }

    companion object {
        private val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

        fun from(value: String): Email {
            return Email(value.lowercase())
        }
    }
}

typealias EmailValue = String

fun EmailValue.toEmail(): Email = Email.from(this)