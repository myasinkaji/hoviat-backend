package ir.markaz.hoviat.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Data
@AllArgsConstructor
public class PageRequest {
    private int page;
    private int pageSize;
    private String orderBy;
    private String direction;

}
