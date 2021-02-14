package ir.markaz.hoviat.model.dao.basicinfo;

import ir.markaz.hoviat.model.entity.basicinfo.CentralGuild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CentralGuildDao extends JpaRepository<CentralGuild, Integer> {

    @Query("select cg.code, cg.name from CentralGuild cg")
    List<Object[]> getIdAndName();
}
