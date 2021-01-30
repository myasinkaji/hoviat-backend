package ir.markaz.hoviat.model.vo;

import ir.markaz.hoviat.model.entity.basicinfo.CentralGuild;
import lombok.Data;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Data
public class CentralGuildVo {
    private final long uniqueId;
    private final int code;
    private final String managerName;
    private final String name;
    private final long postalCode;
    private final boolean active;
    private final String phone;

    public CentralGuildVo(CentralGuild guild) {
        this.code = guild.getCode();
        this.managerName = guild.getManagerName();
        this.name = guild.getName();
        this.phone = guild.getPhone();
        this.uniqueId = guild.getUniqueId();
        this.postalCode = guild.getPostalCode();
        this.active = guild.isActive();
    }
}
