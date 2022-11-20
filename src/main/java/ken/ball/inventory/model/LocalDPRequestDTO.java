package ken.ball.inventory.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@JsonDeserialize
@NoArgsConstructor
public class LocalDPRequestDTO extends CardRequestDTO implements Serializable {
    private String exchangeCd;
    private String mainDpCd;
    private String localDpCd;
    private int odnFrom;
    private int odnTo;

    @Builder(builderMethodName = "lDpRequestBuilder")
    public LocalDPRequestDTO(String cardType, String name, String status, String floor, int sparePortCnt, String exchangeCd, String mainDpCd,
                             String localDpCd, int odnFrom, int odnTo) {
        super(cardType, name, status, floor, sparePortCnt);
        this.exchangeCd = exchangeCd;
        this.mainDpCd = mainDpCd;
        this.localDpCd = localDpCd;
        this.odnFrom = odnFrom;
        this.odnTo = odnTo;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class LocalRequestBuilder{}
}
