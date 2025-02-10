package io.github.shiniseong.willofember.shared.application.domain.enums

/**
 * 사용자 등급
 *
 * @property NORMAL 일반 사용자
 * @property AD_FREE 광고 제거
 * @property PREMIUM 프리미엄
 */
enum class UserGrade {
    /**
     * 일반 사용자
     */
    NORMAL,

    /**
     * 광고 제거
     */
    AD_FREE,

    /**
     * 프리미엄
     */
    PREMIUM,
    ;
}

typealias UserGradeValue = String