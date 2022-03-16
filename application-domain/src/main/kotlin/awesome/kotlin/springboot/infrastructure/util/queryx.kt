package awesome.kotlin.springboot.infrastructure.util

import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.core.types.dsl.SimpleExpression

/**
 * @Author Heli
 */
infix fun <T> SimpleExpression<T>.inFilterEmpty(right: List<T>?): BooleanExpression? =
    if (right.isNullOrEmpty()) null else `in`(right)
