package ir.markaz.hoviat.model.entity.basicinfo;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Mohammad Yasin Sadeghi
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "central_guild")
public final class CentralGuild extends Guild {
    public CentralGuild() {
    }

    public CentralGuild(int code, String name, long uniqueId, long postalCode,
                        String managerName, String phone, String mobile, boolean active) {
        super(code, name, uniqueId, postalCode, managerName, phone, mobile, active);
    }
}
