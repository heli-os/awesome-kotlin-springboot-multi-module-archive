package awesome.kotlin.springboot.domain.user.repository

import awesome.kotlin.springboot.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport

/**
 * @Author Heli
 */
interface UserRepository : JpaRepository<User, Long>

interface UserRepositoryCustom {

//    fun load(status: List<User.Status>?, pageable: Pageable): Page<User>
}

class UserRepositoryImpl : QuerydslRepositorySupport(User::class.java), UserRepositoryCustom {

//    override fun load(status: List<User.Status>?, pageable: Pageable): Page<User> {
//        val results: <>
//    }
}
