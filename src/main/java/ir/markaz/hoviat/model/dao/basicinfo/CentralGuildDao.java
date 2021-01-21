package ir.markaz.hoviat.model.dao.basicinfo;

import ir.markaz.hoviat.model.dao.util.HibernateUtil;
import ir.markaz.hoviat.model.entity.basicinfo.CentralGuild;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CentralGuildDao extends JpaRepository<CentralGuild, Integer> {
}
