package ir.markaz.hoviat.model.entity.identity;

import ir.markaz.hoviat.model.entity.basicinfo.Agent;
import ir.markaz.hoviat.model.entity.basicinfo.SubUnit;
import ir.markaz.hoviat.model.entity.tag.ArchiveTag;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Table(name = "identity_status")
@Data
public final class IdentityStatus {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    @Column(name = "status", length = 1, nullable = false)
    private short status;
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @MapsId
    private Identity identity;

}
