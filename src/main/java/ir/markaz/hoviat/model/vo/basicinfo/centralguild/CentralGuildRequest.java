package ir.markaz.hoviat.model.vo.basicinfo.centralguild;

import lombok.Data;
import lombok.NonNull;

@Data
public class CentralGuildRequest {
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

}
