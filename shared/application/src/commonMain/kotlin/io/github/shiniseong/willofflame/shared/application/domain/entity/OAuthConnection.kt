package io.github.shiniseong.willofflame.shared.application.domain.entity

import io.github.shiniseong.willofember.shared.application.domain.util.now
import io.github.shiniseong.willofflame.shared.application.domain.enums.OAuthProvider
import io.github.shiniseong.willofflame.shared.application.domain.vo.Email
import kotlinx.datetime.LocalDateTime

data class OAuthConnection(
    val id: String,
    val provider: OAuthProvider,
    val oauthId: String,
    val email: Email,
    val profileImageUrl: String? = null,
    val refreshToken: String,
    val isMain: Boolean = false,
    val isDeleted: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun markAsMain(): OAuthConnection {
        return this.copy(isMain = true)
    }

    fun markAsDeleted(): OAuthConnection {
        return this.copy(isDeleted = true)
    }

    fun updateRefreshToken(newRefreshToken: String): OAuthConnection {
        return this.copy(refreshToken = newRefreshToken)
    }
}
