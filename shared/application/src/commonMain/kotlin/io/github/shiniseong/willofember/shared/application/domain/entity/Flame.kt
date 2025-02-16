package io.github.shiniseong.willofember.shared.application.domain.entity

import io.github.shiniseong.willofember.shared.application.domain.enums.FlameVisibility
import io.github.shiniseong.willofember.shared.application.domain.util.now
import io.github.shiniseong.willofember.shared.application.domain.vo.Color
import kotlinx.datetime.LocalDateTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid


/**
 * 불꽃, 테마.
 */
@OptIn(ExperimentalUuidApi::class)
data class Flame(
    /**
     * ID.
     */
    val id: String = Uuid.random().toString(),
    /**
     * 소유한 사용자 ID.
     */
    val userId: String,
    /**
     * 제목.
     */
    val title: String,
    /**
     * 색상.
     */
    val color: Color,
    /**
     * 최소 요구 땔깜량
     */
    val requiredKindling: Int,
    /**
     * 최대 땔깜량
     */
    val maxKindling: Int,

    /**
     * 땔깜 필요량 증가율
     */
    val kindlingGrowthRate: Float,

    /**
     * 땔깜 요구량 증가 기능 활성화 여부
     */
    val isKindlingGrowthEnabled: Boolean,

    /**
     * 현재 불꽃 크기
     */
    val size: Float,

    /**
     * 불꽃 가시성
     * @see FlameVisibility
     */
    val visibility: FlameVisibility,

    /**
     * 메인 불꽃 여부
     */
    val isMain: Boolean,

    /**
     * 생성일시.
     */
    val createdAt: LocalDateTime = LocalDateTime.now(),

    /**
     * 마지막 수정일시.
     */
    val updatedAt: LocalDateTime = LocalDateTime.now(),
) : DomainEntity
