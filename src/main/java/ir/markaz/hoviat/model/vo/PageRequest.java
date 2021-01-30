package ir.markaz.hoviat.model.vo;

import lombok.Data;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Data
public class PageRequest {
    private int page;
    private int size;
    private String sortBy;
    private boolean desc;
}
