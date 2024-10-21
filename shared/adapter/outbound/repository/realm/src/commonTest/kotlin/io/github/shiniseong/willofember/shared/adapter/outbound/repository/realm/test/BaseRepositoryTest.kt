package io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.test

import io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.entity.UserEntity
import io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.repository.UserRepositoryRealmImpl
import io.github.shiniseong.willofember.shared.application.domain.entity.User
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import kotlin.test.Test
import kotlin.test.assertEquals

class BaseRepositoryTest {
    companion object {
        private val sampleRealmConfig = RealmConfiguration.Builder(
            schema = setOf(UserEntity::class),
        ).inMemory().build()
        val sampleRealm = Realm.open(sampleRealmConfig)
        val sampleUsers = listOf(
            User(
                id = "uuid-1",
                email = "shini12@example.com",
                nickname = "shiniseong",
                oauthProvider = "google",
                oauthId = "google-oauth-id-1",
                profileImage = "https://example.com/profile-image-1",
            ),
            User(
                id = "uuid-2",
                email = "tommy12@example.com",
                nickname = "tommy",
                oauthProvider = "google",
                oauthId = "google-oauth-id-2",
                profileImage = "https://example.com/profile-image-2",
            ),
            User(
                id = "uuid-3",
                email = "jason12@example.com",
                nickname = "jason",
                oauthProvider = "google",
                oauthId = "google-oauth-id-3",
                profileImage = "https://example.com/profile-image-3",
            ),
            User(
                id = "uuid-4",
                email = "anna12@example.com",
                nickname = "anna",
                oauthProvider = "google",
                oauthId = "google-oauth-id-4",
                profileImage = "https://example.com/profile-image-4",
            ),
        )

        val userRepository = UserRepositoryRealmImpl(sampleRealm)
    }

    @Test
    fun deleteAllUsers() {
        println("clearAllUsers")
        userRepository.saveAll(sampleUsers)
        val savedUsers = userRepository.findAll()
        println("savedUsers: $savedUsers")
        assertEquals(4, savedUsers.size)
        userRepository.deleteAll()
        println("... deleted all users")
        val clearedUsers = userRepository.findAll()
        println("clearedUsers: $clearedUsers")
        assertEquals(0, clearedUsers.size)
    }


}