package ir.markaz.hoviat.model.vo.basicinfo.tagcompany;

import lombok.Data;
import lombok.NonNull;

@Data
public class TagCompanyRequest {
    private int id;
    @NonNull
    private Long uniqueId;
    @NonNull
    private String companyName;
    @NonNull
    private Long postalCode;
    private int establishedYear;
    @NonNull
    private String managerName;
    @NonNull
    private Boolean producer;
    @NonNull
    private Boolean importer;
    @NonNull
    private Boolean visualTag;
    @NonNull
    private Boolean rfidTag;
    @NonNull
    private Boolean microchipTag;
    @NonNull
    private Boolean bolusesTag;
    @NonNull
    private Boolean active;
}
