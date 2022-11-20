package ken.ball.inventory.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Port extends AbstractAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "port-sequence-generator")
    @GenericGenerator(name = "port-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                @Parameter(name = "sequence_name", value = "port_seq_no")
            }
    )
    private Long id;
    private String portType;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
    private String name;
    private String status;
    private String projectCode;
    private int reservedBwB;
    private int reservedBwP;
    private int reservedBwS;
    private int reservedBwV;
}
