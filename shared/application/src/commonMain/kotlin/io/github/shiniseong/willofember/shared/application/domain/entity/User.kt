package io.github.shiniseong.willofember.shared.application.domain.entity

import io.github.shiniseong.willofember.shared.application.domain.enums.Gender
import io.github.shiniseong.willofember.shared.application.domain.enums.OAuthProvider
import io.github.shiniseong.willofember.shared.application.domain.enums.UserGrade

/**
 * 유저 도메인 엔티티
 */
data class User(
    /**
     * 유저 식별자
     */
    val id: String,
    /**
     * 유저 성별
     */
    val gender: Gender,
    /**
     * 유저 이메일
     */
    val email: String,
    /**
     * 유저 등급
     * @see UserGrade
     */
    val grade: UserGrade = UserGrade.NORMAL,
    /**
     * 유저 닉네임
     */
    val nickname: String,
    /**
     * OAuth 제공자
     * @see OAuthProvider
     */
    val oauthProvider: OAuthProvider,
    /**
     * OAuth 식별자
     */
    val oauthId: String,
    /**
     * 프로필 이미지
     */
    val profileImage: String?,
) : DomainEntity {

}
