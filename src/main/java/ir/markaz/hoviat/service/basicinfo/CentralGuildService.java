package ir.markaz.hoviat.service.basicinfo;

import ir.markaz.hoviat.model.dao.basicinfo.CentralGuildDao;
import ir.markaz.hoviat.model.entity.basicinfo.CentralGuild;
import ir.markaz.hoviat.service.ServiceUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CentralGuildService {
    private final CentralGuildDao dao;

    public CentralGuildService(CentralGuildDao dao) {
        this.dao = dao;
    }


    public void save(CentralGuild centralGuild) {
        dao.save(centralGuild);
    }

    public Page<CentralGuild> getPage(ir.markaz.hoviat.model.vo.PageRequest request) {
        return dao.findAll(ServiceUtil.createSpringPageRequest(request, CentralGuild.CODE));
    }
}
