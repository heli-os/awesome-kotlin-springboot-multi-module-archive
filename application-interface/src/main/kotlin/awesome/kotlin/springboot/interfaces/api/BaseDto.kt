package awesome.kotlin.springboot.interfaces.api

import awesome.kotlin.springboot.domain.configuration.jpa.BaseEntity
import awesome.kotlin.springboot.domain.configuration.jpa.requiredId
import awesome.kotlin.springboot.util.lateInit
import org.springframework.data.domain.Page
import java.time.LocalDateTime

/**
 * @Author Heli
 */

data class PagedDto<T>(
    val content: List<T>,
    val page: PageDto
)

data class PageDto(
    val number: Int,
    val size: Int,
    val totalElements: Long,
    val totalPages: Int,
    val first: Boolean,
    val last: Boolean,
    val hasNext: Boolean,
    val hasPrevious: Boolean
)

inline fun <T, R> Page<T>.pagedDto(convert: (T) -> R): PagedDto<R> {
    return PagedDto(
        content = content.map(convert),
        page = toDto()
    )
}

fun Page<*>.toDto() = PageDto(
    number = number,
    size = size,
    totalElements = totalElements,
    totalPages = totalPages,
    first = isFirst,
    last = isLast,
    hasNext = hasNext(),
    hasPrevious = hasPrevious()
)

abstract class EntityDto {
    var id: Long? = lateInit()
    var uuid: String? = lateInit()
    var createdAt: LocalDateTime? = lateInit()
    var modifiedAt: LocalDateTime? = lateInit()
}

inline fun <reified T : EntityDto> T.entityData(entity: BaseEntity): T {
    id = entity.requiredId
    createdAt = entity.createAt
    modifiedAt = entity.modifiedAt
    return this
}
