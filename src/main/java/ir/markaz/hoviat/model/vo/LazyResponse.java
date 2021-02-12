package ir.markaz.hoviat.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LazyResponse {
    @JsonProperty(value = "id")
    private final int code;
    @JsonProperty(value = "title")
    private final String name;

    public LazyResponse(Object[] entry) {
        this.code = (int) entry[0];
        this.name = (String) entry[1];
    }
}
