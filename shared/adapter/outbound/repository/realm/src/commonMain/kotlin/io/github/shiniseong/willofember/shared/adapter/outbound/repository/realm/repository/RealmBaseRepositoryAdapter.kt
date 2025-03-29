package io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.repository

import io.github.shiniseong.willofember.shared.application.domain.entity.DomainEntity
import io.github.shiniseong.willofember.shared.application.port.outbound.repository.BaseRepositoryPort
import io.github.shiniseong.willofember.shared.application.port.outbound.repository.entity.OutboundEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.types.RealmObject
import kotlin.reflect.KClass


abstract class RealmBaseRepositoryAdapter<D : DomainEntity, P>(
    protected val realm: Realm,
    protected val persistenceClazz: KClass<P>
) : BaseRepositoryPort<D> where P : RealmObject, P : OutboundEntity<D> {
    override suspend fun findById(id: String): D? =
        realm.query(persistenceClazz, "id == $0", id)
            .first()
            .find()
            ?.toDomain()

    override suspend fun findAll(): List<D> {
        return realm.query(persistenceClazz).find().map { it.toDomain() }
    }

    override suspend fun findAllByIds(ids: List<String>): List<D> {
        return realm.query(persistenceClazz, "id IN $0", ids)
            .find()
            .map { it.toDomain() }
    }

    override suspend fun save(entity: D): D {
        realm.writeBlocking { copyToRealm(entity.toPersistenceEntity()) }
        return entity
    }

    override suspend fun saveOrUpdate(entity: D): D {
        realm.writeBlocking { copyToRealm(entity.toPersistenceEntity(), UpdatePolicy.ALL) }
        return entity
    }

    override suspend fun saveAll(entities: List<D>): List<D> {
        realm.writeBlocking { entities.forEach { copyToRealm(it.toPersistenceEntity()) } }
        return entities
    }

    override suspend fun saveAllOrUpdate(entities: List<D>): List<D> {
        realm.writeBlocking { entities.forEach { copyToRealm(it.toPersistenceEntity(), UpdatePolicy.ALL) } }
        return entities
    }

    override suspend fun deleteById(id: String) {
        realm.writeBlocking {
            query(persistenceClazz, "id == $0", id)
                .first()
                .find()
                ?.let { delete(it) }
        }
    }

    override suspend fun deleteAllByIds(ids: List<String>) {
        realm.writeBlocking {
            ids.forEach { id ->
                query(persistenceClazz, "id == $0", id)
                    .first()
                    .find()
                    ?.let { delete(it) }
            }
        }
    }

    override suspend fun deleteAll() {
        realm.writeBlocking {
            val beDeletedEntities = query(persistenceClazz).find()
            delete(beDeletedEntities)
        }
    }

    protected abstract fun D.toPersistenceEntity(): P

}
