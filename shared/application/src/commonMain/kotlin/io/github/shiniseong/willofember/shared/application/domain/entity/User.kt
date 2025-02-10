package io.github.shiniseong.willofember.shared.application.domain.entity

import io.github.shiniseong.willofember.shared.application.domain.enums.Gender
import io.github.shiniseong.willofember.shared.application.domain.enums.OAuthProvider
import io.github.shiniseong.willofember.shared.application.domain.enums.UserGrade

data class User(
    val id: String,
    val gender: Gender,
    val email: String,
    val grade: UserGrade = UserGrade.NORMAL,
    val nickname: String,
    val oauthProvider: OAuthProvider,
    val oauthId: String,
    val profileImage: String?,
) : DomainEntity {

}
