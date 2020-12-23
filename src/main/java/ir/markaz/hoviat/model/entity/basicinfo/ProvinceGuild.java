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

}
