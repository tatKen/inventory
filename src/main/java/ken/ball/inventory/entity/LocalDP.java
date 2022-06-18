package ken.ball.inventory.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
@NoArgsConstructor
public class LocalDP extends AbstractAudit{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "localdp-sequence-generator")
    @GenericGenerator(name = "localdp-sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@Parameter(name = "sequence_name", value = "localdp_seq_no")}
    )
    private Long id;

    @OneToOne(mappedBy = "localDP")
    private Card card;
    private String exchangeCd;
    private String MainDpCd;
    private String localDpCd;
    private Long odnFrom;
    private Long odnTo;


}
