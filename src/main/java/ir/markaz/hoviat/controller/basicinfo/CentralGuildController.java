package ir.markaz.hoviat.controller.basicinfo;

import ir.markaz.hoviat.controller.Addresses;
import ir.markaz.hoviat.model.vo.CentralGuildVo;
import ir.markaz.hoviat.model.vo.PageRequest;
import ir.markaz.hoviat.service.basicinfo.CentralGuildService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = Addresses.CENTRAL_GUILD)
@Slf4j
public class CentralGuildController {
    private final CentralGuildService service;

    public CentralGuildController(CentralGuildService service) {
        this.service = service;
    }

    @GetMapping
    @CrossOrigin
    public List<CentralGuildVo> getPage(@RequestBody PageRequest request) {
        final var pageResult = service.getPage(request);
        return pageResult.stream().parallel().map(CentralGuildVo::new).collect(Collectors.toList());
    }
}
