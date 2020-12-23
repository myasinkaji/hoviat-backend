package ir.markaz.hoviat.model.entity.tag;

import ir.markaz.hoviat.model.entity.basicinfo.Agent;
import ir.markaz.hoviat.model.entity.basicinfo.Contractor;
import ir.markaz.hoviat.model.entity.basicinfo.ProvinceGuild;
import ir.markaz.hoviat.model.entity.identity.Identity;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Table(name = "archive_tag")
@Data
public final class ArchiveTag {
    @Id
    @Column(name = "code", length = 15, nullable = false, unique = true)
    private long code;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "treq_fk")
    private TagRequest tagRequest;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "pg_fk")
    private ProvinceGuild provinceGuild;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "con_fk")
    private Contractor contractor;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_fk")
    private Agent agent;
    @OneToOne(mappedBy = "archiveTag", fetch = FetchType.LAZY)
    private Identity identity;
}
