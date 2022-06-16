package ken.ball.inventory.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

@Data
@Entity
@NoArgsConstructor
public class Card extends AbstractAudit{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String cardType;

    @NaturalId
    private String name;

    private String status;

    private String floor;

    private Long sparePortCnt;
}
