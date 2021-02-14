package ir.markaz.hoviat.model.dao.basicinfo;

import ir.markaz.hoviat.model.entity.basicinfo.ProvinceGuild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Repository
public interface ProvinceGuildDao extends JpaRepository<ProvinceGuild, Integer> {
}
