package io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.repository

import io.github.shiniseong.willofember.shared.application.domain.entity.DomainEntity
import io.github.shiniseong.willofember.shared.application.port.outbound.repository.BaseRepository
import io.github.shiniseong.willofember.shared.application.port.outbound.repository.entity.OutboundEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.types.RealmObject
import kotlin.reflect.KClass


abstract class RealmBaseRepository<D : DomainEntity, P>(
    protected val realm: Realm,
    protected val persistenceClazz: KClass<P>
) : BaseRepository<D> where P : RealmObject, P : OutboundEntity<D> {
    override fun findById(id: String): D? =
        realm.query(persistenceClazz, "id == $0", id)
            .first()
            .find()
            ?.toDomain()

    override fun findAll(): List<D> {
        return realm.query(persistenceClazz).find().map { it.toDomain() }
    }

    override fun findAllByIds(ids: List<String>): List<D> {
        return realm.query(persistenceClazz, "id IN $0", ids)
            .find()
            .map { it.toDomain() }
    }

    override fun save(entity: D): D {
        realm.writeBlocking { copyToRealm(entity.toPersistenceEntity()) }
        return entity
    }

    override fun saveAll(entities: List<D>): List<D> {
        realm.writeBlocking { entities.forEach { copyToRealm(it.toPersistenceEntity()) } }
        return entities
    }

    override fun deleteById(id: String) {
        realm.writeBlocking {
            query(persistenceClazz, "id == $0", id)
                .first()
                .find()
                ?.let { delete(it) }
        }
    }

    override fun deleteAllByIds(ids: List<String>) {
        realm.writeBlocking {
            ids.forEach { id ->
                query(persistenceClazz, "id == $0", id)
                    .first()
                    .find()
                    ?.let { delete(it) }
            }
        }
    }

    override fun deleteAll() {
        realm.writeBlocking {
            val beDeletedEntities = query(persistenceClazz).find()
            delete(beDeletedEntities)
        }
    }

    protected abstract fun D.toPersistenceEntity(): P

}
