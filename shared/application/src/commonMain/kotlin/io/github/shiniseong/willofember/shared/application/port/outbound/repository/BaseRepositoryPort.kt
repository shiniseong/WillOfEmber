package io.github.shiniseong.willofember.shared.application.port.outbound.repository

interface BaseRepositoryPort<T> {
    suspend fun findById(id: String): T?
    suspend fun findAll(): List<T>
    suspend fun findAllByIds(ids: List<String>): List<T>
    suspend fun save(entity: T): T
    suspend fun saveOrUpdate(entity: T): T
    suspend fun saveAll(entities: List<T>): List<T>
    suspend fun saveAllOrUpdate(entities: List<T>): List<T>
    suspend fun deleteById(id: String)
    suspend fun deleteAllByIds(ids: List<String>)
    suspend fun deleteAll()
}