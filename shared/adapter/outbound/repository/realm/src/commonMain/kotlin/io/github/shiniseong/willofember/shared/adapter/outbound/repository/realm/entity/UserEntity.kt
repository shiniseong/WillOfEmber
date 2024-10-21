package io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.entity

import io.github.shiniseong.willofember.shared.application.domain.entity.User
import io.github.shiniseong.willofember.shared.application.port.outbound.repository.entity.OutboundEntity
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class UserEntity : RealmObject, OutboundEntity<User> {
    @PrimaryKey
    var id: String = ""
    var email: String = ""
    var nickname: String = ""
    var oauthProvider: String = ""
    var oauthId: String = ""
    var profileImage: String? = null


    override fun toDomain(): User = User(
        id = id,
        email = email,
        nickname = nickname,
        oauthProvider = oauthProvider,
        oauthId = oauthId,
        profileImage = profileImage
    )
}

