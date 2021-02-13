package ir.markaz.hoviat.service.basicinfo;

import ir.markaz.hoviat.model.dao.basicinfo.TagCompanyDao;
import ir.markaz.hoviat.model.entity.basicinfo.TagCompany;
import ir.markaz.hoviat.model.vo.PageRequest;
import ir.markaz.hoviat.model.vo.PageResponse;
import ir.markaz.hoviat.service.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TagCompanyService {
    private TagCompanyDao dao;

    public TagCompanyService(TagCompanyDao dao) {
        this.dao = dao;
    }

    public void save(TagCompany tagCompany) {
        dao.save(tagCompany);
    }

    public void update(TagCompany tagCompany) {
        if (dao.existsById(tagCompany.getId()))
            dao.save(tagCompany);
        else
            throw new IllegalArgumentException("There is no such record now to update");
    }

    public PageResponse<Page<TagCompany>> getPage(PageRequest pageRequest) {
        Page<TagCompany> page = dao.findAll(ServiceUtil.createSpringPageRequest(pageRequest,
                TagCompany.ACTIVE, TagCompany.DEFAULT_DIRECTION));
//        long count = dao.count();
        return new PageResponse<>(page, page.getTotalElements());
    }

    public void delete(int code) {
        try {
            dao.deleteById(code);
        } catch (EmptyResultDataAccessException e) {
            log.debug("there is no record with this code: {}", code);
        }
    }
}
