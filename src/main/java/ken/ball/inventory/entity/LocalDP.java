package ken.ball.inventory.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonDeserialize(builder = LocalDP.LocalDPJsonBuilder.class)
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
    private String mainDpCd;
    private String localDpCd;
    private int odnFrom;
    private int odnTo;

    @Builder(builderMethodName = "LocalDPBuilder")
    public LocalDP(String createdBy, LocalDateTime createdDateTime, String lastModifiedBy, LocalDateTime lastModifiedDateTime, Integer version, Long id, Card card, String exchangeCd, String mainDpCd, String localDpCd, int odnFrom, int odnTo) {
        super(createdBy, createdDateTime, lastModifiedBy, lastModifiedDateTime, version);
        this.id = id;
        this.card = card;
        this.exchangeCd = exchangeCd;
        this.mainDpCd = mainDpCd;
        this.localDpCd = localDpCd;
        this.odnFrom = odnFrom;
        this.odnTo = odnTo;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class LocalDPJsonBuilder{}
}
