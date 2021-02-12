package ir.markaz.hoviat.model.dao.basicinfo;

import ir.markaz.hoviat.model.entity.basicinfo.CountryDivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Repository
public interface CountryDivisionDao extends JpaRepository<CountryDivision, Integer> {
    @Query("select cd.id, cd.name from CountryDivision cd")
    List<Object[]> getIdAndName();
}
