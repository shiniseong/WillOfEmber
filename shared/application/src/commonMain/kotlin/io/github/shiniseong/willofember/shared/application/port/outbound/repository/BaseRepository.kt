package io.github.shiniseong.willofember.shared.application.port.outbound.repository

interface BaseRepository<T> {
    fun findById(id: String): T?
    fun findAll(): List<T>
    fun findAllByIds(ids: List<String>): List<T>
    fun save(entity: T): T
    fun saveAll(entities: List<T>): List<T>
    fun deleteById(id: String)
    fun deleteAllByIds(ids: List<String>)
    fun deleteAll()
}