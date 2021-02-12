package ir.markaz.hoviat.model.vo.basicinfo.provinceguild;

import ir.markaz.hoviat.model.entity.basicinfo.ProvinceGuild;
import lombok.Data;

@Data
public class ProvinceGuildResponse {
    private final long uniqueId;
    private final int code;
    private final String managerName;
    private final String name;
    private final long postalCode;
    private final boolean active;
    private final String phone;
    private final String mobile;
    private final String centralGuildName;
    private final int centralGuildCode;
    private final String countryDivisionName;
    private final int countryDivisionId;

    public ProvinceGuildResponse(ProvinceGuild guild) {
        this.code = guild.getCode();
        this.managerName = guild.getManagerName();
        this.name = guild.getName();
        this.phone = guild.getPhone();
        this.mobile = guild.getMobile();
        this.uniqueId = guild.getUniqueId();
        this.postalCode = guild.getPostalCode();
        this.active = guild.isActive();
        this.centralGuildName = guild.getCentralGuild().getName();
        this.centralGuildCode = guild.getCentralGuild().getCode();
        this.countryDivisionName = guild.getCountryDivision().getName();
        this.countryDivisionId = guild.getCountryDivision().getId();
    }
}
