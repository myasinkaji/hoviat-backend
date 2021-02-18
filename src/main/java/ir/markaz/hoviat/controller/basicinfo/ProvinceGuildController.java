package ir.markaz.hoviat.controller.basicinfo;

import ir.markaz.hoviat.controller.Addresses;
import ir.markaz.hoviat.model.entity.basicinfo.CentralGuild;
import ir.markaz.hoviat.model.entity.basicinfo.CountryDivision;
import ir.markaz.hoviat.model.entity.basicinfo.ProvinceGuild;
import ir.markaz.hoviat.model.vo.PageRequest;
import ir.markaz.hoviat.model.vo.PageResponse;
import ir.markaz.hoviat.model.vo.basicinfo.provinceguild.ProvinceGuildRequest;
import ir.markaz.hoviat.model.vo.basicinfo.provinceguild.ProvinceGuildResponse;
import ir.markaz.hoviat.service.basicinfo.CentralGuildService;
import ir.markaz.hoviat.service.basicinfo.CountryDivisionService;
import ir.markaz.hoviat.service.basicinfo.ProvinceGuildService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = Addresses.PROVINCE_GUILD)
@Slf4j
public class ProvinceGuildController {
    private final ProvinceGuildService service;
    private final CentralGuildService centralGuildService;
    private final CountryDivisionService countryDivisionService;

    public ProvinceGuildController(ProvinceGuildService service,
                                   CentralGuildService centralGuildService,
                                   CountryDivisionService countryDivisionService) {
        this.service = service;
        this.centralGuildService = centralGuildService;
        this.countryDivisionService = countryDivisionService;
    }

    @GetMapping
    public PageResponse<List<ProvinceGuildResponse>> getPage(@PathParam("page") int page,
                                                             @PathParam("pageSize") int pageSize,
                                                             @PathParam("orderBy") String orderBy,
                                                             @PathParam("order") String order) {
        final var pageResult =
                service.getPage(new PageRequest(page, pageSize, orderBy, order));
        List<ProvinceGuildResponse> results =
                pageResult.getData().stream().parallel().map(ProvinceGuildResponse::new)
                        .collect(Collectors.toList());
        log.info("Getting page...");
        return new PageResponse<>(results, pageResult.getCount());
    }

    @PostMapping
    public void save(@Validated @RequestBody ProvinceGuildRequest request) {
        postmanAdapter(request);
        Optional<CentralGuild> centralGuild =
                centralGuildService.findByCode(request.getCentralGuildCode());
        if (centralGuild.isEmpty())
            throw new IllegalArgumentException("There is no central guild with passed code");

        Optional<CountryDivision> countryDivision =
                countryDivisionService.findById(request.getCountryDivisionId());
        if (countryDivision.isEmpty())
            throw new IllegalArgumentException("There is no country division with passed code");

        var guild = new ProvinceGuild(request.getCode(), request.getName(), request.getUniqueId(),
                request.getPostalCode(), request.getManagerName(), request.getPhone(),
                request.getMobile(), request.isActive(), countryDivision.get(), centralGuild.get());

        service.save(guild);
    }

    //Todo remove these
    private void postmanAdapter(ProvinceGuildRequest request) {
        request.setMobile(request.getMobile().replaceAll("-", ""));
        request.setPhone(request.getPhone().replaceAll("-", ""));
    }

    @PutMapping
    public void update(@Validated @RequestBody ProvinceGuildRequest request) {
        postmanAdapter(request);
        Optional<CentralGuild> centralGuild =
                centralGuildService.findByCode(request.getCentralGuildCode());
        if (centralGuild.isEmpty())
            throw new IllegalArgumentException("There is no central guild with passed code");

        Optional<CountryDivision> countryDivision =
                countryDivisionService.findById(request.getCountryDivisionId());
        if (countryDivision.isEmpty())
            throw new IllegalArgumentException("There is no country division with passed code");

        var guild = new ProvinceGuild(request.getCode(), request.getName(), request.getUniqueId(),
                request.getPostalCode(), request.getManagerName(), request.getPhone(),
                request.getMobile(), request.isActive(), countryDivision.get(), centralGuild.get());

        service.update(guild);
    }

    @DeleteMapping
    public void delete(@RequestParam("code") int code) {
        service.delete(code);
        log.info("deleted code: {}", code);
    }
}
