package awesome.kotlin.springboot.interfaces.api.user

import awesome.kotlin.springboot.domain.user.entity.User
import awesome.kotlin.springboot.domain.user.service.UserQuery
import awesome.kotlin.springboot.interfaces.api.PagedDto
import awesome.kotlin.springboot.interfaces.api.pagedDto
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @Author Heli
 */
@RestController
class UserRestController(
    private val userQuery: UserQuery
) {

    @GetMapping(
        value = ["/api/v1/user"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getUsers(
        @RequestParam(required = false) status: List<User.Status>?,
        @PageableDefault pageable: Pageable
    ): PagedDto<UserDto> {
        val result = userQuery.load(pageable = pageable, status = status)

        return result.pagedDto { it.toDto() }
    }
}
