package ir.markaz.hoviat.model.entity.basicinfo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Table(name = "country_division")
@Data
@NamedStoredProcedureQueries(
        value = {
                @NamedStoredProcedureQuery(
                        name = "getAll",
                        procedureName = "getAll",
                        resultClasses = CountryDivision.class,
                        parameters = {}
                )
        }
)
@NoArgsConstructor
public final class CountryDivision {
    public static final String CODE = "code";
    public static final String TYPE = "type";
    public static final String DEFAULT_DIRECTION = "asc";

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "code", length = 16, unique = true, updatable = false)
    private int code;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    private CountryDivision parent;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "type", length = 1)
    private int type;
    @OneToMany(mappedBy = "parent")
    private List<CountryDivision> children;

    public CountryDivision(int code, CountryDivision parent, String name, int type) {
        this.code = code;
        this.parent = parent;
        this.name = name;
        this.type = type;
    }
}
