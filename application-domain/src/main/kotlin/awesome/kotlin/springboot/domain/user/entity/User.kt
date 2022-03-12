package awesome.kotlin.springboot.domain.user.entity

import awesome.kotlin.springboot.domain.configuration.jpa.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table

/**
 * @Author Heli
 */
@Entity
@Table(name = "users")
class User private constructor(
    var displayName: String,
    var status: Status
) : BaseEntity() {

    enum class Status {
        ACTIVATE, DEACTIVATE
    }

    fun update(
        displayName: String
    ) = apply {
        this.displayName = displayName
    }

    fun delete() = apply {
        this.status = Status.DEACTIVATE
    }

    companion object {

        fun create(
            name: String
        ) = User(
            displayName = name,
            status = Status.ACTIVATE
        )
    }
}
