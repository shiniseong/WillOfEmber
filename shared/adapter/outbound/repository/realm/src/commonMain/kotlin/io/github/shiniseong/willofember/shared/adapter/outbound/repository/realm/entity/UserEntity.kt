package io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.entity

import io.github.shiniseong.willofember.shared.application.domain.entity.User
import io.github.shiniseong.willofember.shared.application.domain.enums.Gender
import io.github.shiniseong.willofember.shared.application.domain.enums.GenderValue
import io.github.shiniseong.willofember.shared.application.domain.enums.UserGrade
import io.github.shiniseong.willofember.shared.application.domain.enums.UserGradeValue
import io.github.shiniseong.willofember.shared.application.port.outbound.repository.entity.OutboundEntity
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class UserEntity : RealmObject, OutboundEntity<User> {
    @PrimaryKey
    var id: String = ""
    var email: String = ""
    var gender: GenderValue = Gender.MALE.name
    var nickname: String = ""
    var oauthProvider: String = ""
    var oauthId: String = ""
    var profileImage: String? = null
    var grade: UserGradeValue = UserGrade.NORMAL.name

    override fun toDomain(): User = User(
        id = id,
        email = email,
        gender = Gender.valueOf(gender),
        grade = UserGrade.valueOf(grade),
        nickname = nickname,
        oauthProvider = oauthProvider,
        oauthId = oauthId,
        profileImage = profileImage
    )
}

