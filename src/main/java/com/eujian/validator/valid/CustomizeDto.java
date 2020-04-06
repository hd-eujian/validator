package com.eujian.validator.valid;

import com.eujian.validator.valid.customize.MyConstraint;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class CustomizeDto implements Serializable {

    @MyConstraint(message = "customize不符合规范")
    private String customize;

    public String getCustomize() {
        return customize;
    }

    public void setCustomize(String customize) {
        this.customize = customize;
    }

    @Override
    public String toString() {
        return "ReqDto{" +
                ", customize='" + customize + '\'' +
                '}';
    }
}
