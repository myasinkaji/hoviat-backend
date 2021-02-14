package ir.markaz.hoviat.model.dao.basicinfo;

import ir.markaz.hoviat.model.entity.basicinfo.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Repository
public interface AgentDao extends JpaRepository<Agent, Long> {
}
