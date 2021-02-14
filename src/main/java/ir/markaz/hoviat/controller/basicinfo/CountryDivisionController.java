package ir.markaz.hoviat.controller.basicinfo;

import ir.markaz.hoviat.controller.Addresses;
import ir.markaz.hoviat.model.entity.basicinfo.CountryDivision;
import ir.markaz.hoviat.model.vo.LazyResponse;
import ir.markaz.hoviat.model.vo.PageRequest;
import ir.markaz.hoviat.model.vo.PageResponse;
import ir.markaz.hoviat.model.vo.basicinfo.countrydivision.CountryDivisionFlatResponse;
import ir.markaz.hoviat.model.vo.basicinfo.countrydivision.CountryDivisionRequest;
import ir.markaz.hoviat.model.vo.basicinfo.countrydivision.CountryDivisionResponse;
import ir.markaz.hoviat.service.basicinfo.CountryDivisionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
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
    public PageResponse<List<CountryDivisionFlatResponse>> getPage(@PathParam("page") int page,
                                                                   @PathParam("pageSize") int pageSize,
                                                                   @PathParam("orderBy") String orderBy,
                                                                   @PathParam("order") String order) {
        final var pageResult =
                service.getPage(new PageRequest(page, pageSize, orderBy, order));
        List<CountryDivisionFlatResponse> results =
                pageResult.getData().stream().parallel().map(CountryDivisionFlatResponse::new)
                        .collect(Collectors.toList());
        log.info("Getting country division page...");
        return new PageResponse<>(results, pageResult.getCount());
    }

    @GetMapping(value = Addresses.TREE)
    @CrossOrigin
    public CountryDivisionResponse getTree() {
        final var parent = service.getParent();
        return extractResponseTree(parent);
    }

    private CountryDivisionResponse mapCountryDivisionResponse(CountryDivision parent) {
        return new CountryDivisionResponse(
                parent.getId(), parent.getCode(), parent.getName(), parent.getType());
    }

    private CountryDivisionResponse extractResponseTree(CountryDivision parent) {
        CountryDivisionResponse root = mapCountryDivisionResponse(parent);
        if (!CollectionUtils.isEmpty(parent.getChildren())) {
            for (CountryDivision countryDivision : parent.getChildren()) {
                var child = extractResponseTree(countryDivision);
                root.addChild(child);
            }
        }
        return root;
    }

    @GetMapping(value = Addresses.LAZY)
    @CrossOrigin
    public PageResponse<List<LazyResponse>> getAllLazy() {
        final var allLazy =
                service.getAllLazy();
        List<LazyResponse> results =
                allLazy.stream().parallel().map(LazyResponse::new)
                        .collect(Collectors.toList());
        log.info("Getting all lazy country divisions...");
        return new PageResponse<>(results, (long) results.size());
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
