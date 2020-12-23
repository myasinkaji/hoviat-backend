package ir.markaz.hoviat.model.entity.basicinfo;

import lombok.Data;

import javax.persistence.*;

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
public final class CountryDivision {
    @Id
    @Column(name = "code")
    private int code;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    private CountryDivision parent;
    @Column(name = "name", nullable = false, length = 50)
    private String name;

}
