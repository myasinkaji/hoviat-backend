package ir.markaz.hoviat.model.entity.basicinfo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Table(name = "herd")
@Data
public final class Herd {
    @Id
    @Column(name = "code", nullable = false, unique = true)
    private int code;
    @Column(name = "epdm", length = 11, nullable = false)
    private String epidemiologicCode;
    @Column(name = "p_code", length = 10, nullable = false)
    private long postalCode;
    @Column(name = "name", length = 30, nullable = false)
    private String name;
    @Column(name = "lng", nullable = false)
    private float lng;
    @Column(name = "lat", nullable = false)
    private float lat;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "div_fk")
    private CountryDivision countryDivision;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cont_fk")
    private Contractor contractor;

}
