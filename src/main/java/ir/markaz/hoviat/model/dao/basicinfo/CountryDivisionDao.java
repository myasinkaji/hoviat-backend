package ir.markaz.hoviat.model.dao.basicinfo;

import ir.markaz.hoviat.model.entity.basicinfo.CountryDivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Repository
public interface CountryDivisionDao extends JpaRepository<CountryDivision, Integer> {

    /*@Autowired
    private SessionFactory sessionFactory;

    public List<CountryDivision> getAll() {
        StoredProcedureQuery query = sessionFactory.openSession().createNamedStoredProcedureQuery("getAll");
        query.execute();
        List<CountryDivision> all = (List<CountryDivision>) query.getResultList();

        return all;
    }*/
}
