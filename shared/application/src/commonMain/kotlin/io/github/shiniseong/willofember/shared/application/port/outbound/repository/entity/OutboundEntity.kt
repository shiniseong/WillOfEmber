package io.github.shiniseong.willofember.shared.application.port.outbound.repository.entity

import io.github.shiniseong.willofember.shared.application.domain.entity.DomainEntity

interface OutboundEntity<D : DomainEntity> {
    fun toDomain(): D
}