package ken.ball.inventory.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(builder = CardRequestDTO.CardRequestBuilder.class)
public class CardRequestDTO implements Serializable {
    @JsonProperty("cardtype")
    private String cardType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("status")
    private String status;
    @JsonProperty("floor")
    private String floor;
    @JsonProperty("spareportcnt")
    private int sparePortCnt;

    @Override
    public String toString() {
        return "CardRequestDTO{" +
                "cardType='" + cardType + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", floor='" + floor + '\'' +
                ", sparePortCnt=" + sparePortCnt +
                '}';
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class CardRequestBuilder{}
}
