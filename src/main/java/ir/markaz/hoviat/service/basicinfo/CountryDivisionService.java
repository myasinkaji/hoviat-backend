package ir.markaz.hoviat.service.basicinfo;

import ir.markaz.hoviat.model.dao.basicinfo.CountryDivisionDao;
import ir.markaz.hoviat.model.entity.basicinfo.CountryDivision;
import ir.markaz.hoviat.model.vo.PageRequest;
import ir.markaz.hoviat.model.vo.PageResponse;
import ir.markaz.hoviat.service.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CountryDivisionService {
    private final CountryDivisionDao dao;

    public CountryDivisionService(CountryDivisionDao dao) {
        this.dao = dao;
    }


    public Optional<CountryDivision> findById(int id) {
        return dao.findById(id);
    }

    public void save(int code, Integer parent, String name, Integer type) {
        CountryDivision parentEntity = findParent(parent);
        dao.save(new CountryDivision(code, parentEntity, name, type));
    }

    private CountryDivision findParent(Integer parent) {
        CountryDivision parentEntity = null;
        if (parent != null) {
            Optional<CountryDivision> parentCountryDivision = findById(parent);
            if (parentCountryDivision.isEmpty())
                throw new IllegalArgumentException("There is no country division with passed code.");
            parentEntity = parentCountryDivision.get();
        }
        return parentEntity;
    }

    public void update(int id, Integer parent, String name, Integer type) {
        Optional<CountryDivision> optionalEntity = findById(id);
        if (optionalEntity.isEmpty())
            throw new IllegalArgumentException("There is no such an country division to update");
        CountryDivision parentEntity = findParent(parent);
        CountryDivision entity = optionalEntity.get();
        entity.setParent(parentEntity);
        entity.setType(type);
        entity.setName(name);
        dao.save(optionalEntity.get());
    }

    public PageResponse<Page<CountryDivision>> getPage(PageRequest pageRequest) {
        Page<CountryDivision> page = dao.findAll(ServiceUtil.createSpringPageRequest(pageRequest,
                CountryDivision.CODE, CountryDivision.DEFAULT_DIRECTION));
        long count = dao.count();
        return new PageResponse<>(page, count);
    }

    public void delete(int code) {
        try {
            dao.deleteById(code);
        } catch (EmptyResultDataAccessException e) {
            log.debug("there is no record with this code: {}", code);
        }
    }
}
