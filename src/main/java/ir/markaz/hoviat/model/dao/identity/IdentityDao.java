package ir.markaz.hoviat.model.dao.identity;

import ir.markaz.hoviat.model.entity.identity.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Repository
public interface IdentityDao extends JpaRepository<Identity, Long> {
}
