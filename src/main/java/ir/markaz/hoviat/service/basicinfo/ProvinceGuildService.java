package ir.markaz.hoviat.service.basicinfo;

import ir.markaz.hoviat.model.dao.basicinfo.ProvinceGuildDao;
import ir.markaz.hoviat.model.entity.basicinfo.ProvinceGuild;
import ir.markaz.hoviat.model.vo.PageRequest;
import ir.markaz.hoviat.model.vo.PageResponse;
import ir.markaz.hoviat.service.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProvinceGuildService {
    private ProvinceGuildDao dao;

    public ProvinceGuildService(ProvinceGuildDao dao) {
        this.dao = dao;
    }

    public void save(ProvinceGuild provinceGuild) {
        dao.save(provinceGuild);
    }

    public void update(ProvinceGuild provinceGuild) {
        if (dao.existsById(provinceGuild.getCode()))
            dao.save(provinceGuild);
        else
            throw new IllegalArgumentException("There is no such record now to update");
    }

    public PageResponse<Page<ProvinceGuild>> getPage(PageRequest pageRequest) {
        Page<ProvinceGuild> page = dao.findAll(ServiceUtil.createSpringPageRequest(pageRequest,
                ProvinceGuild.CODE, ProvinceGuild.DEFAULT_DIRECTION));
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
