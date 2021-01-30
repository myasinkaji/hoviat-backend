package ir.markaz.hoviat.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * @author Mohammad Yasin Sadeghi
 */
public class ServiceUtil {
    public static PageRequest createSpringPageRequest(ir.markaz.hoviat.model.vo.PageRequest request, String sort) {
        return PageRequest.of(request.getPage(), request.getSize(), createSpringSort(request, sort));
    }

    private static Sort createSpringSort(ir.markaz.hoviat.model.vo.PageRequest request, String sort) {
        String s = StringUtils.isBlank(request.getSortBy()) ? sort : request.getSortBy();
        return Sort.by(!request.isDesc() ? Sort.Order.desc(s) : Sort.Order.asc(s));
    }
}
