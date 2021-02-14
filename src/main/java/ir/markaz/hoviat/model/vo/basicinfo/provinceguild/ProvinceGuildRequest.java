package ir.markaz.hoviat.model.vo.basicinfo.provinceguild;

import lombok.Data;
import lombok.NonNull;


@Data
public class ProvinceGuildRequest {
    private int code;
    @NonNull
    private String name;
    @NonNull
    private long uniqueId;
    @NonNull
    private long postalCode;
    @NonNull
    private String managerName;
    @NonNull
    private String phone;
    @NonNull
    private String mobile;
    @NonNull
    private boolean active;
    @NonNull
    private Integer centralGuildCode;
    @NonNull
    private Integer countryDivisionId;
}
