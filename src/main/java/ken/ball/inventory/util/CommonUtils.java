package ken.ball.inventory.util;

import java.util.Optional;

public class CommonUtils {
    public static String strNullToEmpty(String src){
        return Optional.ofNullable(src).orElse("");
    }

}
