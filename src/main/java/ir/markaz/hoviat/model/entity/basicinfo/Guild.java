package ir.markaz.hoviat.model.entity.basicinfo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Mohammad Yasin Sadeghi
 */
@MappedSuperclass
@Data
public sealed abstract class Guild permits CentralGuild, ProvinceGuild {
    @Id
    @Column(name = "code")
    private int code;
    @Column(name = "name", length = 30, nullable = false)
    private String name;
    //Todo create index on this field
    //Todo check length
    @Column(name = "uid", length = 12, nullable = false, unique = true)
    private long uniqueId;
    @Column(name = "p_code", length = 10, nullable = false)
    private long postalCode;
    @Column(name = "m_name", length = 30, nullable = false)
    private String managerName;
    @Column(name = "phone", length = 11, nullable = false, unique = true)
    private String phone;
    @Column(name = "mobile", length = 11, nullable = false, unique = true)
    private String mobile;
    @Column(name = "active", nullable = false)
    private boolean active;

}
