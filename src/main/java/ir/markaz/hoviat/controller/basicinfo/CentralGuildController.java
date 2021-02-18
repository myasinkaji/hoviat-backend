package ir.markaz.hoviat.controller.basicinfo;

import ir.markaz.hoviat.controller.Addresses;
import ir.markaz.hoviat.model.entity.basicinfo.CentralGuild;
import ir.markaz.hoviat.model.vo.PageRequest;
import ir.markaz.hoviat.model.vo.PageResponse;
import ir.markaz.hoviat.model.vo.LazyResponse;
import ir.markaz.hoviat.model.vo.basicinfo.centralguild.CentralGuildRequest;
import ir.markaz.hoviat.model.vo.basicinfo.centralguild.CentralGuildResponse;
import ir.markaz.hoviat.service.basicinfo.CentralGuildService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public PageResponse<List<CentralGuildResponse>> getPage(@PathParam("page") int page,
                                                            @PathParam("pageSize") int pageSize,
                                                            @PathParam("orderBy") String orderBy,
                                                            @PathParam("order") String order) {
        final var pageResult =
                service.getPage(new PageRequest(page, pageSize, orderBy, order));
        List<CentralGuildResponse> results =
                pageResult.getData().stream().parallel().map(CentralGuildResponse::new)
                        .collect(Collectors.toList());
        log.info("Getting page...");
        return new PageResponse<>(results, pageResult.getCount());
    }

    @GetMapping(value = Addresses.LAZY)
    public PageResponse<List<LazyResponse>> getAllLazy() {
        final var allLazy =
                service.getAllLazy();
        List<LazyResponse> results =
                allLazy.stream().parallel().map(LazyResponse::new)
                        .collect(Collectors.toList());
        log.info("Getting all lazy central guilds...");
        return new PageResponse<>(results, (long) results.size());
    }

    @PostMapping
    public void saveCentralGuild(@Validated @RequestBody CentralGuildRequest request) {
        postmanAdapter(request);

        var guild = new CentralGuild(request.getCode(), request.getName(), request.getUniqueId(),
                request.getPostalCode(), request.getManagerName(), request.getPhone(),
                request.getMobile(), request.isActive());

        service.save(guild);
    }

    //Todo remove these
    private void postmanAdapter(CentralGuildRequest request) {
        request.setMobile(request.getMobile().replaceAll("-", ""));
        request.setPhone(request.getPhone().replaceAll("-", ""));
    }

    @PutMapping
    public void updateCentralGuild(@Validated @RequestBody CentralGuildRequest request) {
        postmanAdapter(request);
        var guild = new CentralGuild(request.getCode(), request.getName(), request.getUniqueId(),
                request.getPostalCode(), request.getManagerName(), request.getPhone(),
                request.getMobile(), request.isActive());

        service.update(guild);
    }

    @DeleteMapping
    public void deleteCentralGuild(@RequestParam("code") int code) {
        service.delete(code);
        log.info("deleted code: {}", code);
    }
}
