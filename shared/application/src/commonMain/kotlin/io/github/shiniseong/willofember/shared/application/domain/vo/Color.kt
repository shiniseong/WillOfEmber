package io.github.shiniseong.willofember.shared.application.domain.vo

class Color(
    override val value: String
) : ValueObject<String> {
    init {
        require(value.length == 7) { "Color value must be 7 characters long" }
        require(value.startsWith("#")) { "Color value must start with #" }
    }

    companion object {
        fun from(value: String): Color {
            return Color(value)
        }
    }
}

typealias ColorValue = String

fun ColorValue.toColor(): Color = Color.from(this)