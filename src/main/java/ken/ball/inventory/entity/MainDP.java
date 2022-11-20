package ken.ball.inventory.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonDeserialize(builder = MainDP.MainDPBuilder.class)
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
    private String mainDpCd;

    @Builder(builderMethodName="MainDPBuilder")
    public MainDP(String createdBy, LocalDateTime createdDateTime, String lastModifiedBy, LocalDateTime lastModifiedDateTime, Integer version, Long id, Card card, String exchangeCd, String mainDpCd) {
        super(createdBy, createdDateTime, lastModifiedBy, lastModifiedDateTime, version);
        this.id = id;
        this.card = card;
        this.exchangeCd = exchangeCd;
        this.mainDpCd = mainDpCd;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class MainDPJsonBuilder{}
}
