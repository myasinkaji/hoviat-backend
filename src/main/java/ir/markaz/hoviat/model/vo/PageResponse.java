package ir.markaz.hoviat.model.vo;

import lombok.Data;
import lombok.NonNull;

@Data
public class PageResponse<T> {
    @NonNull
    private T data;
    @NonNull
    private Long count;

}
