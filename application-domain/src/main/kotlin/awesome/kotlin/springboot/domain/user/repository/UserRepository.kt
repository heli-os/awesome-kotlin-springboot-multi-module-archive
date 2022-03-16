package awesome.kotlin.springboot.domain.user.repository

import awesome.kotlin.springboot.domain.user.entity.QUser.user
import awesome.kotlin.springboot.domain.user.entity.User
import awesome.kotlin.springboot.infrastructure.util.inFilterEmpty
import com.querydsl.core.QueryResults
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport

/**
 * @Author Heli
 */
interface UserRepository : JpaRepository<User, Long>, UserRepositoryCustom

interface UserRepositoryCustom {

    fun load(status: List<User.Status>?, pageable: Pageable): Page<User>
}

class UserRepositoryImpl : QuerydslRepositorySupport(User::class.java), UserRepositoryCustom {

    override fun load(status: List<User.Status>?, pageable: Pageable): Page<User> {
        val results: QueryResults<User> = from(user)
            .where(
                user.status.inFilterEmpty(status)
            )
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .orderBy(user.createAt.desc())
            .fetchResults()

        return PageImpl(results.results, pageable, results.total)
    }
}
