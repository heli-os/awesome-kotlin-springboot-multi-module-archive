package awesome.kotlin.springboot.domain.configuration.jpa

import awesome.kotlin.springboot.util.lateInit
import awesome.kotlin.springboot.util.notNull
import java.time.LocalDateTime
import javax.persistence.*

/**
 * @Author Heli
 */
@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = lateInit()

    @Column(updatable = false)
    var createAt: LocalDateTime = lateInit()

    var modifiedAt: LocalDateTime = lateInit()

    @PrePersist
    fun prePersist() {
        val now = LocalDateTime.now()
        createAt = now
        modifiedAt = now
    }

    @PreUpdate
    fun preUpdate() {
        modifiedAt = LocalDateTime.now()
    }
}

val BaseEntity.requiredId: Long
    get() = id.notNull { "Entity[${javaClass.simpleName}].id is null" }
