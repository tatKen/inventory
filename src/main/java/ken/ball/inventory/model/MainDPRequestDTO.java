package ken.ball.inventory.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonDeserialize
public class MainDPRequestDTO extends CardRequestDTO implements Serializable {
    private String exchangeCd;
    private String mainDpCd;

    @Builder(builderMethodName = "mDPRequestBuilder")
    public MainDPRequestDTO(String cardType, String name, String status, String floor, int sparePortCnt, String exchangeCd, String mainDpCd) {
        super(cardType, name, status, floor, sparePortCnt);
        this.exchangeCd = exchangeCd;
        this.mainDpCd = mainDpCd;
    }

    @Override
    public String toString() {
        return "MainDPRequestDTO{" +
                "exchangeCd='" + exchangeCd + '\'' +
                ", mainDpCd='" + mainDpCd + "' " + super.toString() +
                '}';
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class MainDPRequestBuilder{}
}
