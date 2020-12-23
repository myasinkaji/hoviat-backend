package ir.markaz.hoviat.model.entity.tag;

import ir.markaz.hoviat.model.entity.basicinfo.CentralGuild;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Table(name = "last_tag_request")
@Data
public final class LastTagRequest {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "a_kind", nullable = false)
    private short animalKind;
    @Column(name = "from_n", length = 15, nullable = false, unique = true)
    private long fromNumber;
    @Column(name = "to_n", length = 15, nullable = false, unique = true)
    private long toNumber;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cg_fk")
    private CentralGuild guild;

}
