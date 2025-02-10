package io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.repository

import io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.entity.UserEntity
import io.github.shiniseong.willofember.shared.application.domain.entity.User
import io.github.shiniseong.willofember.shared.application.port.outbound.repository.UserRepositoryPort
import io.realm.kotlin.Realm

class UserRepository(realm: Realm) :
    RealmBaseRepositoryAdapter<User, UserEntity>(realm, UserEntity::class),
    UserRepositoryPort {


    override fun User.toPersistenceEntity(): UserEntity {
        val userEntity = UserEntity()
        userEntity.id = id
        userEntity.email = email
        userEntity.gender = gender.name
        userEntity.oauthProvider = oauthProvider.name
        userEntity.oauthId = oauthId
        userEntity.nickname = nickname
        userEntity.profileImage = profileImage
        userEntity.grade = grade.name
        return userEntity
    }

}
