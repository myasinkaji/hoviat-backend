package ir.markaz.hoviat.model.entity.basicinfo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "province_guild")
@Data
public final class ProvinceGuild extends Guild {
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "div_fk")
    private CountryDivision countryDivision;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cg_fk")
    private CentralGuild centralGuild;

    public ProvinceGuild() {

    }

    public ProvinceGuild(int code, String name, long uniqueId, long postalCode,
                         String managerName, String phone, String mobile, boolean active,
                         CountryDivision countryDivision, CentralGuild centralGuild) {
        super(code, name, uniqueId, postalCode, managerName, phone, mobile, active);
        this.countryDivision = countryDivision;
        this.centralGuild = centralGuild;
    }
}
