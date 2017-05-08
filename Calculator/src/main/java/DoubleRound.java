import java.math.BigDecimal;
import java.math.RoundingMode;

class DoubleRound {
    public Double doubleRound(Double i) {
        double templateDouble = i;
        return new BigDecimal(templateDouble).setScale(4, RoundingMode.HALF_UP).doubleValue();
    }


}
