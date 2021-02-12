package ir.markaz.hoviat.model.vo.basicinfo.centralguild;

import ir.markaz.hoviat.model.entity.basicinfo.CentralGuild;
import lombok.Data;

@Data
public class CentralGuildResponse {
    private final long uniqueId;
    private final int code;
    private final String managerName;
    private final String name;
    private final long postalCode;
    private final boolean active;
    private final String phone;
    private final String mobile;

    public CentralGuildResponse(CentralGuild guild) {
        this.code = guild.getCode();
        this.managerName = guild.getManagerName();
        this.name = guild.getName();
        this.phone = guild.getPhone();
        this.mobile = guild.getMobile();
        this.uniqueId = guild.getUniqueId();
        this.postalCode = guild.getPostalCode();
        this.active = guild.isActive();
    }
}
