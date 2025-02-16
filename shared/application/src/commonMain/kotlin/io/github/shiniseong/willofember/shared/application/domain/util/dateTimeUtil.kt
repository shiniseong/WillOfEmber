package io.github.shiniseong.willofember.shared.application.domain.util

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

typealias DateTimeString = String

fun LocalDateTime.Companion.now(): LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
fun DateTimeString.toLocalDateTime(): LocalDateTime = LocalDateTime.parse(this)
