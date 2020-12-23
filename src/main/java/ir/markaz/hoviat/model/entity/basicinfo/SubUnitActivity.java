package ir.markaz.hoviat.model.entity.basicinfo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Table(name = "sub_unit_activity")
@Data
public final class SubUnitActivity {
    @Id
    @Column(name = "code", nullable = false, unique = true)
    private int code;
    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

}
