package ir.markaz.hoviat.model.dao.tag;

import ir.markaz.hoviat.model.entity.tag.TagRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Repository
public interface TagRequestDao extends JpaRepository<TagRequest, Integer> {
}
