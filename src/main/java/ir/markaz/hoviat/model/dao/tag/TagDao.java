package ir.markaz.hoviat.model.dao.tag;

import ir.markaz.hoviat.model.entity.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Repository
public interface TagDao extends JpaRepository<Tag, Long> {
}
