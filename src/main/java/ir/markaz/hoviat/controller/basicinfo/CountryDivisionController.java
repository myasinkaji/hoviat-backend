package ir.markaz.hoviat.controller.basicinfo;

import ir.markaz.hoviat.controller.Addresses;
import ir.markaz.hoviat.model.vo.PageRequest;
import ir.markaz.hoviat.model.vo.PageResponse;
import ir.markaz.hoviat.model.vo.basicinfo.countrydivision.CountryDivisionRequest;
import ir.markaz.hoviat.model.vo.basicinfo.countrydivision.CountryDivisionResponse;
import ir.markaz.hoviat.service.basicinfo.CountryDivisionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = Addresses.COUNTRY_DIVISION)
@Slf4j
public class CountryDivisionController {
    private final CountryDivisionService service;

    public CountryDivisionController(CountryDivisionService service) {
        this.service = service;
    }

    @GetMapping
    @CrossOrigin
    public PageResponse<List<CountryDivisionResponse>> getPage(@PathParam("page") int page,
                                                               @PathParam("pageSize") int pageSize,
                                                               @PathParam("orderBy") String orderBy,
                                                               @PathParam("order") String order) {
        final var pageResult =
                service.getPage(new PageRequest(page, pageSize, orderBy, order));
        List<CountryDivisionResponse> results =
                pageResult.getData().stream().parallel().map(CountryDivisionResponse::new)
                        .collect(Collectors.toList());
        log.info("Getting country division page...");
        return new PageResponse<>(results, pageResult.getCount());
    }

    @PostMapping
    @CrossOrigin
    public void save(@Validated @RequestBody CountryDivisionRequest request) {
        service.save(request.getCode(), request.getParent(), request.getName(), request.getType());
        log.info("saved country division with code: {}", request.getCode());
    }

    @PutMapping
    @CrossOrigin
    public void update(@Validated @RequestBody CountryDivisionRequest request) {
        service.update(request.getId(), request.getParent(), request.getName(), request.getType());
        log.info("updated country division with code: {}", request.getCode());
    }

    @DeleteMapping
    @CrossOrigin
    public void delete(@RequestParam("code") int code) {
        service.delete(code);
        log.info("deleted country division with code: {}", code);
    }

}
