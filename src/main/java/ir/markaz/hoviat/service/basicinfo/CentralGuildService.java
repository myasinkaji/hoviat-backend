package ir.markaz.hoviat.service.basicinfo;

import ir.markaz.hoviat.model.dao.basicinfo.CentralGuildDao;
import ir.markaz.hoviat.model.entity.basicinfo.CentralGuild;
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
public class CentralGuildService {
    private final CentralGuildDao dao;

    public CentralGuildService(CentralGuildDao dao) {
        this.dao = dao;
    }


    public void save(CentralGuild centralGuild) {
        dao.save(centralGuild);
    }

    public Optional<CentralGuild> findByCode(int code) {
        return dao.findById(code);
    }

    public void update(CentralGuild centralGuild) {
        if (dao.existsById(centralGuild.getCode()))
            dao.save(centralGuild);
        else
            throw new IllegalArgumentException("There is no such record now to update");
    }

    public PageResponse<Page<CentralGuild>> getPage(PageRequest pageRequest) {
        Page<CentralGuild> page = dao.findAll(ServiceUtil.createSpringPageRequest(pageRequest,
                CentralGuild.CODE, CentralGuild.DEFAULT_DIRECTION));
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
