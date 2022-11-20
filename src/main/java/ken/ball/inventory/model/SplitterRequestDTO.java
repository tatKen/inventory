package ken.ball.inventory.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class SplitterRequestDTO extends CardRequestDTO implements Serializable {
    private String splitterClass;
    private String oltId;
    private String slotId;
    private String interfaceNo;
    private String createdBy;
    private int bwB;
    private int bwP;
    private int bwS;
    private int bwV;
}
