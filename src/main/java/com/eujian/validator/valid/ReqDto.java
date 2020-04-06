package com.eujian.validator.valid;

import com.eujian.validator.valid.customize.MyConstraint;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class ReqDto implements Serializable {

    @NotNull(message = "id不能为空")
    private Integer id;

    @NotNull(message = "名称不能为空")
    @Length(message = "名称最长10个字",max = 10)
    private String name;

    @NotNull(message = "金额不能为空")
    @DecimalMin(message = "金额最少为0",value = "0")
    private BigDecimal money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return "ReqDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
