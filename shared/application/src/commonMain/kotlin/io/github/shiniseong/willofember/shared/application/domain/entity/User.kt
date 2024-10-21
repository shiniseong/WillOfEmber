package io.github.shiniseong.willofember.shared.application.domain.entity

import io.github.shiniseong.willofember.shared.application.domain.enums.Gender

data class User(
    val id: String,
    val gender: Gender,
    val email: String,
    val nickname: String,
    val oauthProvider: String,
    val oauthId: String,
    val profileImage: String?,
) : DomainEntity {

}
