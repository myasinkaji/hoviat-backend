package ir.markaz.hoviat.model.vo.basicinfo.countrydivision;

import lombok.Data;
import lombok.NonNull;

@Data
public class CountryDivisionRequest {
    private int id;
    @NonNull
    private Integer code;
    private Integer parent;
    @NonNull
    private String name;
    private Integer type;
}
