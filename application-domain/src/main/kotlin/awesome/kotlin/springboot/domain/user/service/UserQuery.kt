package awesome.kotlin.springboot.domain.user.service

import awesome.kotlin.springboot.domain.user.entity.User
import awesome.kotlin.springboot.domain.user.repository.UserRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * @Author Heli
 */
@Service
class UserQuery(
    private val userRepository: UserRepository
) {

    fun load(status: List<User.Status>?, pageable: Pageable): Page<User> {
        return userRepository.load(status = status, pageable = pageable)
    }
}
