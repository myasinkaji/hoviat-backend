package ir.markaz.hoviat.model.vo.basicinfo.countrydivision;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class CountryDivisionResponse {
    private int id;
    private int code;
    private String name;
    private Integer type;
    private List<CountryDivisionResponse> children = new ArrayList<>();

    public CountryDivisionResponse(int id, int code, @NonNull String name, Integer type) {
        setId(id);
        setCode(code);
        setName(name);
        setType(type);
    }

    public synchronized void addChild(CountryDivisionResponse child) {
        children.add(child);
    }
}
