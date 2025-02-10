package io.github.shiniseong.willofember.shared.application.domain.enums

/**
 * 불꽃 가시성 제한
 * - PRIVATE: 나만 볼 수 있음
 * - FOLLOWERS: 팔로워만 볼 수 있음
 * - PUBLIC: 누구나 볼 수 있음
 */
enum class FlameVisibility {
    /**
     * 나만 볼 수 있음
     */
    PRIVATE,

    /**
     * 팔로워만 볼 수 있음
     */
    FOLLOWERS,

    /**
     * 누구나 볼 수 있음
     */
    PUBLIC
}