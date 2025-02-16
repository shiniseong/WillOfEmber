package io.github.shiniseong.willofember.shared.adapter.outbound.repository.realm.entity

import io.github.shiniseong.willofember.shared.application.domain.entity.Flame
import io.github.shiniseong.willofember.shared.application.domain.enums.FlameVisibility
import io.github.shiniseong.willofember.shared.application.domain.util.toLocalDateTime
import io.github.shiniseong.willofember.shared.application.domain.vo.toColor
import io.github.shiniseong.willofember.shared.application.port.outbound.repository.entity.OutboundEntity
import io.realm.kotlin.types.RealmObject

class FlameEntity : RealmObject, OutboundEntity<Flame> {
    var id: String = ""
    var userId: String = ""
    var title: String = ""
    var color: String = ""
    var requiredKindling: Int = 0
    var maxKindling: Int = 0
    var kindlingGrowthRate: Float = 0f
    var isKindlingGrowthEnabled: Boolean = false
    var size: Float = 0f
    var visibility: String = ""
    var isMain: Boolean = false
    var createdAt: String = ""
    var updatedAt: String = ""


    override fun toDomain(): Flame = Flame(
        id = id,
        userId = userId,
        title = title,
        color = color.toColor(),
        requiredKindling = requiredKindling,
        maxKindling = maxKindling,
        kindlingGrowthRate = kindlingGrowthRate,
        isKindlingGrowthEnabled = isKindlingGrowthEnabled,
        size = size,
        visibility = FlameVisibility.valueOf(visibility),
        isMain = isMain,
        createdAt = createdAt.toLocalDateTime(),
        updatedAt = updatedAt.toLocalDateTime(),
    )

}
