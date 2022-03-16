package awesome.kotlin.springboot.interfaces.api.user

import awesome.kotlin.springboot.domain.user.entity.User
import awesome.kotlin.springboot.interfaces.api.EntityDto
import awesome.kotlin.springboot.interfaces.api.entityData

/**
 * @Author Heli
 */
data class UserDto(
    val displayName: String,
    val status: String
) : EntityDto()

internal fun User.toDto() = UserDto(
    displayName = displayName,
    status = status.name
).entityData(this)
