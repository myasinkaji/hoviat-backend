package ir.markaz.hoviat.model.entity.basicinfo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Table(name = "agent")
@Data
public final class Agent {
    @Id
    @Column(name = "n_code", length = 10, nullable = false, unique = true)
    private long nationalCode;
    @Column(name = "uid", length = 12, nullable = false, unique = true)
    private long uniqueId;
    @Column(name = "b_dt", nullable = false)
    private Date birthDate;
    @Column(name = "p_code", length = 10, nullable = false)
    private long postalCode;
    @Column(name = "fname", length = 20, nullable = false)
    private String firstname;
    @Column(name = "lname", length = 30, nullable = false)
    private String lastname;
    @Column(name = "phone", length = 11, nullable = false, unique = true)
    private String phone;
    @Column(name = "mobile", length = 11, nullable = false, unique = true)
    private String mobile;
    @Column(name = "grade", length = 1, nullable = false)
    private short grade;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "div_fk")
    private CountryDivision countryDivision;
    //Todo List is better than Set???????
/*    @ManyToMany(mappedBy = "agents")
    private List<Contractor> contractors;*/
}
