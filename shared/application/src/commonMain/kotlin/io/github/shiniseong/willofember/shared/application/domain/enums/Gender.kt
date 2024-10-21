package io.github.shiniseong.willofember.shared.application.domain.enums

enum class Gender(val value: String) {
    MALE("1"),
    FEMALE("2"),
    OTHER("3"),
    ;

    companion object {
        fun fromValue(value: String) =
            entries.find { it.value == value } ?: throw IllegalArgumentException("Unknown value: $value")
    }
}

typealias GenderValue = String

fun GenderValue.toGenderEnum() = Gender.fromValue(this)