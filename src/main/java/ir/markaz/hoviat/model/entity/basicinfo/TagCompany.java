package ir.markaz.hoviat.model.entity.basicinfo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Table(name = "tag_company")
@Data
public final class TagCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "uid", length = 12, nullable = false, unique = true)
    private long uniqueId;
    @Column(name = "cmp_name", length = 50)
    private String companyName;
    @Column(name = "p_code", length = 10, nullable = false)
    private long postalCode;
    @Column(name = "e_year")
    private int establishedYear;
    @Column(name = "m_name", length = 30, nullable = false)
    private String managerName;
    @Column(name = "is_pdcr", nullable = false)
    private boolean producer;
    @Column(name = "is_imptr", nullable = false)
    private boolean importer;
    @Column(name = "p_visual", nullable = false)
    private boolean visualTag;
    @Column(name = "p_rfid", nullable = false)
    private boolean rfidTag;
    @Column(name = "p_mchip", nullable = false)
    private boolean microchipTag;
    @Column(name = "p_bol", nullable = false)
    private boolean bolusesTag;
    @Column(name = "active", nullable = false)
    private boolean active;

}
