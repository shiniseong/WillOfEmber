package io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.test

import io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.entity.UserEntity
import io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.repository.UserRepository
import io.github.shiniseong.willofember.shared.application.domain.entity.User
import io.github.shiniseong.willofember.shared.application.domain.enums.Gender
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
                gender = Gender.MALE,
                nickname = "shiniseong",
                oauthProvider = "google",
                oauthId = "google-oauth-id-1",
                profileImage = "https://example.com/profile-image-1",
            ),
            User(
                id = "uuid-2",
                email = "tommy12@example.com",
                gender = Gender.MALE,
                nickname = "tommy",
                oauthProvider = "google",
                oauthId = "google-oauth-id-2",
                profileImage = "https://example.com/profile-image-2",
            ),
            User(
                id = "uuid-3",
                email = "jason12@example.com",
                gender = Gender.MALE,
                nickname = "jason",
                oauthProvider = "google",
                oauthId = "google-oauth-id-3",
                profileImage = "https://example.com/profile-image-3",
            ),
            User(
                id = "uuid-4",
                email = "anna12@example.com",
                gender = Gender.MALE,
                nickname = "anna",
                oauthProvider = "google",
                oauthId = "google-oauth-id-4",
                profileImage = "https://example.com/profile-image-4",
            ),
        )

        val userRepository = UserRepository(sampleRealm)
    }

    @Test
    fun findById() {
        println("findById")
        val targetId = "uuid-2"
        userRepository.saveAll(sampleUsers)
        val savedUsers = userRepository.findAll()
        println("savedUsers: $savedUsers")
        assertEquals(4, savedUsers.size)
        val foundUser = userRepository.findById(targetId)
        println("foundUser: $foundUser")
        assertEquals(sampleUsers.find { it.id == targetId }, foundUser)
        userRepository.deleteAll()
    }

    @Test
    fun findAllByIds() {
        println("findAllByIds")
        val targetIds = listOf("uuid-1", "uuid-3")
        userRepository.saveAll(sampleUsers)
        val savedUsers = userRepository.findAll()
        println("savedUsers: $savedUsers")
        val foundUsers = userRepository.findAllByIds(targetIds)
        println("foundUsers: $foundUsers")
        assertEquals(sampleUsers.filter { it.id in targetIds }, foundUsers)
        userRepository.deleteAll()
    }

    @Test
    fun findAll() {
        println("findAll")
        userRepository.saveAll(sampleUsers)
        val savedUsers = userRepository.findAll()
        println("savedUsers: $savedUsers")
        assertEquals(4, savedUsers.size)
        userRepository.deleteAll()
    }

    @Test
    fun saveUser() {
        println("saveUser")
        val beforeUsers = userRepository.findAll()
        println("beforeUsers: $beforeUsers")
        assertEquals(0, beforeUsers.size)
        userRepository.save(sampleUsers.first())
        val savedUsers = userRepository.findAll()
        println("savedUsers: $savedUsers")
        assertEquals(1, savedUsers.size)
        assertEquals(sampleUsers.first(), savedUsers.first())
        userRepository.deleteAll()
    }

    @Test
    fun saveOrUpdateUser() {
        println("saveOrUpdateUser")
        val beforeUsers = userRepository.findAll()
        println("beforeUsers: $beforeUsers")
        assertEquals(0, beforeUsers.size)
        userRepository.saveOrUpdate(sampleUsers.first())
        val savedUsers = userRepository.findAll()
        println("savedUsers: $savedUsers")
        assertEquals(1, savedUsers.size)
        assertEquals(sampleUsers.first(), savedUsers.first())
        userRepository.saveOrUpdate(sampleUsers.first().copy(nickname = "shiniseong-updated"))
        val updatedUsers = userRepository.findAll()
        println("updatedUsers: $updatedUsers")
        assertEquals(1, updatedUsers.size)
        assertEquals(sampleUsers.first().copy(nickname = "shiniseong-updated"), updatedUsers.first())
        userRepository.deleteAll()
    }

    @Test
    fun saveAllUsers() {
        println("saveAllUsers")
        val beforeUsers = userRepository.findAll()
        println("beforeUsers: $beforeUsers")
        assertEquals(0, beforeUsers.size)
        userRepository.saveAll(sampleUsers)
        val savedUsers = userRepository.findAll()
        println("savedUsers: $savedUsers")
        assertEquals(4, savedUsers.size)
        userRepository.deleteAll()
    }

    @Test
    fun saveAllOrUpdate() {
        println("saveAllOrUpdate")
        val beforeUsers = userRepository.findAll()
        println("beforeUsers: $beforeUsers")
        assertEquals(0, beforeUsers.size)
        userRepository.saveAllOrUpdate(sampleUsers)
        val savedUsers = userRepository.findAll()
        println("savedUsers: $savedUsers")
        assertEquals(4, savedUsers.size)
        userRepository.saveAllOrUpdate(sampleUsers.map { it.copy(nickname = "${it.nickname}-updated") })
        val updatedUsers = userRepository.findAll()
        println("updatedUsers: $updatedUsers")
        assertEquals(4, updatedUsers.size)
        assertEquals(sampleUsers.map { it.copy(nickname = "${it.nickname}-updated") }, updatedUsers)
        userRepository.deleteAll()
    }

    @Test
    fun deleteById() {
        println("deleteById")
        val targetId = "uuid-2"
        userRepository.saveAll(sampleUsers)
        val savedUsers = userRepository.findAll()
        println("savedUsers: $savedUsers")
        assertEquals(4, savedUsers.size)
        userRepository.deleteById(targetId)
        val deletedUser = userRepository.findById(targetId)
        println("deletedUser: $deletedUser")
        assertEquals(3, userRepository.findAll().size)
        assertEquals(null, deletedUser)
        userRepository.deleteAll()
    }

    @Test
    fun deleteAllByIds() {
        println("deleteAllByIds")
        val targetIds = listOf("uuid-1", "uuid-3")
        userRepository.saveAll(sampleUsers)
        val savedUsers = userRepository.findAll()
        println("savedUsers: $savedUsers")
        assertEquals(4, savedUsers.size)
        userRepository.deleteAllByIds(targetIds)
        val deletedUsers = userRepository.findAllByIds(targetIds)
        println("deletedUsers: $deletedUsers")
        assertEquals(2, userRepository.findAll().size)
        assertEquals(emptyList(), deletedUsers)
        userRepository.deleteAll()
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
        userRepository.deleteAll()
    }


}