package ir.markaz.hoviat.model.entity.basicinfo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Table(name = "rancher")
@Data
public final class Rancher {
    @Id
    @Column(name = "n_code", length = 10, nullable = false, unique = true)
    private long nationalCode;
    @Column(name = "b_dt", nullable = false)
    private Date birthDate;
    @Column(name = "fname", length = 20, nullable = false)
    private String firstname;
    @Column(name = "lname", length = 30, nullable = false)
    private String lastname;
    @Column(name = "phone", length = 11, unique = true)
    private String phone;
    @Column(name = "mobile", length = 11, nullable = false, unique = true)
    private String mobile;
    @Column(name = "islg", nullable = false)
    private boolean legal;
    @Column(name = "cnid", length = 11)
    private String companyNationalId;
    @Column(name = "cmp_name", length = 50)
    private String companyName;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "div_fk")
    private CountryDivision countryDivision;
}
