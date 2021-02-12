package ir.markaz.hoviat.model.vo.basicinfo.countrydivision;

import ir.markaz.hoviat.model.entity.basicinfo.CountryDivision;
import lombok.Data;

@Data
public class CountryDivisionResponse {
    private int id;
    private int code;
    private Integer parentId;
    private String parentName;
    private String name;
    private Integer type;

    public CountryDivisionResponse(CountryDivision entity) {
        setId(entity.getId());
        setCode(entity.getCode());
        setName(entity.getName());
        setType(entity.getType());
        if (entity.getParent() != null) {
            setParentId(entity.getParent().getId());
            setParentName(entity.getParent().getName());
        }
    }
}
