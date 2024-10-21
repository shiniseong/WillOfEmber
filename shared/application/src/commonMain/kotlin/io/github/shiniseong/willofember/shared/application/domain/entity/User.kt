package io.github.shiniseong.willofember.shared.application.domain.entity

data class User(
    val id: String,
    val email: String,
    val nickname: String,
    val oauthProvider: String,
    val oauthId: String,
    val profileImage: String?,
) : DomainEntity {

}
