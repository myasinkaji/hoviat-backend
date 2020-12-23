package ir.markaz.hoviat.model.entity.basicinfo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Table(name = "sub_unit")
@Data
public final class SubUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "uid", length = 12, nullable = false, unique = true)
    private long uniqueId;
    @Column(name = "active", nullable = false)
    private boolean active;
    @Column(name = "capacity", nullable = false)
    private short capacity;
    @Column(name = "lic_st", nullable = false)
    private boolean hasLicense;
    @Column(name = "lic_nu", length = 10)
    private String licenseNumber;
    @Column(name = "lic_is_dt")
    private Date licenseIssueDate;
    @Column(name = "lic_exp_dt")
    private Date licenseExpireDate;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "h_fk")
    private Herd herd;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "sac_fk")
    private SubUnitActivity activity;

}
