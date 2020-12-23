package ir.markaz.hoviat.model.entity.identity;

import ir.markaz.hoviat.model.entity.basicinfo.Agent;
import ir.markaz.hoviat.model.entity.basicinfo.Contractor;
import ir.markaz.hoviat.model.entity.basicinfo.CountryDivision;
import ir.markaz.hoviat.model.entity.basicinfo.SubUnit;
import ir.markaz.hoviat.model.entity.tag.ArchiveTag;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Table(name = "identity")
@Data
public final class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    @Column(name = "imported", nullable = false)
    private boolean imported;
    @Column(name = "sex", length = 1, nullable = false)
    private short sex;
    @Column(name = "b_dt", nullable = false)
    private Date birthDate;
    @Column(name = "cr_dt", nullable = false)
    private Date createDate;
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "at_fk")
    private ArchiveTag archiveTag;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "su_fk")
    private SubUnit subUnit;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ag_fk")
    private Agent agent;
    @OneToOne(mappedBy = "identity", fetch = FetchType.LAZY)
    private IdentityStatus status;
}
