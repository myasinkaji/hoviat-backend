package ir.markaz.hoviat.model.entity.tag;

import ir.markaz.hoviat.model.entity.basicinfo.CentralGuild;
import ir.markaz.hoviat.model.entity.basicinfo.TagCompany;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Table(name = "tag_request")
@Data
public final class TagRequest {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "a_kind", nullable = false)
    private short animalKind;
    @Column(name = "tag_type", nullable = false)
    private short tagType;
    @Column(name = "count", nullable = false)
    private short count;
    @Column(name = "status", nullable = false)
    private short status;
    @Column(name = "from_n", length = 15, unique = true)
    private long fromNumber;
    @Column(name = "to_n", length = 15, unique = true)
    private long toNumber;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "tc_id")
    private TagCompany tagCompany;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cg_fk")
    private CentralGuild guild;

}
