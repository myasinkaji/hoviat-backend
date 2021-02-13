package ir.markaz.hoviat.model.vo.basicinfo.tagcompany;

import ir.markaz.hoviat.model.entity.basicinfo.TagCompany;
import lombok.Data;

@Data
public class TagCompanyResponse {
    private int id;
    private Long uniqueId;
    private String companyName;
    private Long postalCode;
    private int establishedYear;
    private String managerName;
    private Boolean producer;
    private Boolean importer;
    private Boolean visualTag;
    private Boolean rfidTag;
    private Boolean microchipTag;
    private Boolean bolusesTag;
    private Boolean active;

    public TagCompanyResponse(TagCompany entity) {
        this.id = entity.getId();
        this.uniqueId = entity.getUniqueId();
        this.companyName = entity.getCompanyName();
        this.postalCode = entity.getPostalCode();
        this.establishedYear = entity.getEstablishedYear();
        this.managerName = entity.getManagerName();
        this.producer = entity.isProducer();
        this.importer = entity.isImporter();
        this.visualTag = entity.isVisualTag();
        this.rfidTag = entity.isRfidTag();
        this.microchipTag = entity.isMicrochipTag();
        this.bolusesTag = entity.isBolusesTag();
        this.active = entity.isActive();
    }
}
