package ir.markaz.hoviat.controller.basicinfo;

import ir.markaz.hoviat.controller.Addresses;
import ir.markaz.hoviat.model.entity.basicinfo.TagCompany;
import ir.markaz.hoviat.model.vo.PageRequest;
import ir.markaz.hoviat.model.vo.PageResponse;
import ir.markaz.hoviat.model.vo.basicinfo.tagcompany.TagCompanyRequest;
import ir.markaz.hoviat.model.vo.basicinfo.tagcompany.TagCompanyResponse;
import ir.markaz.hoviat.service.basicinfo.TagCompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = Addresses.TAG_COMPANY)
@Slf4j
public class TagCompanyController {
    private final TagCompanyService service;

    public TagCompanyController(TagCompanyService service) {
        this.service = service;
    }

    @GetMapping
    @CrossOrigin
    public PageResponse<List<TagCompanyResponse>> getPage(@PathParam("page") int page,
                                                          @PathParam("pageSize") int pageSize,
                                                          @PathParam("orderBy") String orderBy,
                                                          @PathParam("order") String order) {
        final var pageResult =
                service.getPage(new PageRequest(page, pageSize, orderBy, order));
        List<TagCompanyResponse> results =
                pageResult.getData().stream().parallel().map(TagCompanyResponse::new)
                        .collect(Collectors.toList());
        log.info("Getting page...");
        return new PageResponse<>(results, pageResult.getCount());
    }

    @PostMapping
    @CrossOrigin
    public void saveTagCompany(@Validated @RequestBody TagCompanyRequest request) {
        var company = new TagCompany(request.getUniqueId(), request.getCompanyName(),
                request.getPostalCode(), request.getEstablishedYear(),
                request.getManagerName(), request.getProducer(), request.getImporter(),
                request.getVisualTag(), request.getRfidTag(), request.getMicrochipTag(),
                request.getBolusesTag(), request.getActive());

        company.setId(request.getId());
        service.save(company);
    }

    @PutMapping
    @CrossOrigin
    public void updateTagCompany(@Validated @RequestBody TagCompanyRequest request) {
        log.info("update is not implemented!");
    }

    @DeleteMapping
    @CrossOrigin
    public void deleteTagCompany(@RequestParam("id") int id) {
        service.delete(id);
        log.info("deleted id: {}", id);
    }
}
