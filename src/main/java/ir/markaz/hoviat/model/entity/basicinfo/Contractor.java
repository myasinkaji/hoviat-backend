package ir.markaz.hoviat.model.entity.basicinfo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Table(name = "contractor")
@Data
public final class Contractor {
    @Id
    @Column(name = "n_code", length = 10, nullable = false, unique = true)
    private long nationalCode;
    @Column(name = "fname", length = 20, nullable = false)
    private String firstname;
    @Column(name = "lname", length = 30, nullable = false)
    private String lastname;
    @Column(name = "uid", length = 12, nullable = false, unique = true)
    private long uniqueId;
    @Column(name = "code", nullable = false, unique = true)
    private int code;
    @Column(name = "phone", length = 11, nullable = false, unique = true)
    private String phone;
    @Column(name = "b_dt", nullable = false)
    private Date birthDate;
    @Column(name = "p_code", length = 10, nullable = false)
    private long postalCode;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "cmp_name", length = 50)
    private String companyName;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "div_fk")
    private CountryDivision countryDivision;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "guild_fk")
    private ProvinceGuild guild;
    //Todo List is better than Set???????
    @ManyToMany
    @JoinTable(name = "agent_contractor", joinColumns = {@JoinColumn(name = "cont_fk", referencedColumnName = "n_code")}
            , inverseJoinColumns = {@JoinColumn(name = "agent_fk", referencedColumnName = "n_code")})
    private List<Agent> agents;
}
