package ken.ball.inventory.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Splitter extends AbstractAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "splitter-sequence-generator")
    @GenericGenerator(name = "splitter-sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@org.hibernate.annotations.Parameter(name = "sequence_name", value = "splitter_seq_no")}
    )
    private Long id;

    @OneToOne(mappedBy = "splitter")
    private Card card;
    private String splitterClass;
    private String oltId;
    private String slotId;
    private String interfaceNo;
    private int bwB;
    private int bwP;
    private int bwS;
    private int bwV;
}
