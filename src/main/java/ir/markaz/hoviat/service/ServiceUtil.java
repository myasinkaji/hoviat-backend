package ir.markaz.hoviat.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * @author Mohammad Yasin Sadeghi
 */
public class ServiceUtil {
    public static PageRequest createSpringPageRequest(
            ir.markaz.hoviat.model.vo.PageRequest pageRequest, String defaultSortProperty, String defaultDirection) {

        return PageRequest.of(pageRequest.getPage(), pageRequest.getPageSize(),
                createSpringSort(pageRequest, defaultSortProperty, defaultDirection));
    }

    private static Sort createSpringSort(
            ir.markaz.hoviat.model.vo.PageRequest request, String defaultSortProperty, String defaultDirection) {
        String orderBy =
                StringUtils.isNotBlank(request.getOrderBy()) ? request.getOrderBy() : defaultSortProperty;
        String direction =
                StringUtils.isNotBlank(request.getDirection()) ? request.getDirection() : defaultDirection;
        return Sort.by(Sort.Direction.fromString(direction), orderBy);
    }
}
