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
public class MainDP extends AbstractAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "maindp-sequence-generator")
    @GenericGenerator(name = "maindp-sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@Parameter(name = "sequence_name", value = "maindp_seq_no")}
    )
    private Long id;

    @OneToOne(mappedBy = "mainDP")
    private Card card;
    private String exchangeCd;
    private String MainDpCd;
}
