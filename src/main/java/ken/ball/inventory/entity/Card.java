package ken.ball.inventory.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/*
* @Data
@EqualsAndHashCode(callSuper = true)
@Entity
@JsonDeserialize(builder = DownloadedFile.DownloadedFileBuilder.class)
@NoArgsConstructor
public class DownloadedFile extends AbstractAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(updatable = false, nullable = false)
    private Long id;
    @NaturalId
    private String filename;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;
    private Integer size;


    @JsonPOJOBuilder(withPrefix = "")
    public static final class DownloadedFileBuilder {
    }
}
*
* @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "card_table_gen")
    @TableGenerator(name = "card_table_gen", table = "table_seq_no", pkColumnName = "table_name", valueColumnName = "id_value", initialValue = 1, allocationSize = 1)
* */

/*
*
* @OneToOne(cascade = CascadeType.ALL)
@JoinTable(name = "emp_workstation",
  joinColumns =
    { @JoinColumn(name = "employee_id", referencedColumnName = "id") },
  inverseJoinColumns =
    { @JoinColumn(name = "workstation_id", referencedColumnName = "id") })
*
* */


@Data
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@JsonDeserialize(builder = Card.CardBuilder.class)
public class Card extends AbstractAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card-sequence-generator")
    @GenericGenerator(name = "card-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                @Parameter(name = "sequence_name", value = "card_seq_no")
            }
    )
    private Long id;

    @OneToMany(mappedBy = "card")
    private Set<Port> ports;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "card_splitter",
        joinColumns = {@JoinColumn(name = "card_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "splitter_id", referencedColumnName = "id")}
    )
    @Basic(fetch = FetchType.LAZY)
    private Splitter splitter;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "card_localDp",
            joinColumns = {@JoinColumn(name = "card_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "localDp_id", referencedColumnName = "id")}
    )
    @Basic(fetch = FetchType.LAZY)
    private LocalDP localDP;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "card_mainDp",
        joinColumns = {@JoinColumn(name = "card_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "mainDp_id", referencedColumnName = "id")}
    )
    @Basic(fetch = FetchType.LAZY)
    private MainDP mainDP;

    private String cardType;

    @NaturalId
    private String name;

    private String status;

    private String floor;

    private Long sparePortCnt;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class CardBuilder {
    }
}
