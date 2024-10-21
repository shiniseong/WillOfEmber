package io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.repository

import io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.entity.UserEntity
import io.github.shiniseong.willofember.shared.application.domain.entity.User
import io.github.shiniseong.willofember.shared.application.domain.enums.Gender
import io.github.shiniseong.willofember.shared.application.port.outbound.repository.UserRepository
import io.realm.kotlin.Realm

class UserRepositoryRealmImpl(realm: Realm) : RealmBaseRepository<User, UserEntity>(realm, UserEntity::class),
    UserRepository {
    override fun User.toPersistenceEntity(): UserEntity {
        val userEntity = UserEntity()
        userEntity.id = id
        userEntity.email = email
        userEntity.gender = Gender.MALE.value
        userEntity.oauthProvider = oauthProvider
        userEntity.oauthId = oauthId
        userEntity.nickname = nickname
        userEntity.profileImage = profileImage
        return userEntity
    }

}
