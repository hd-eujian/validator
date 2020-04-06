package com.eujian.validator.valid.customize;

import org.slf4j.Logger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValid implements ConstraintValidator<MyConstraint,String> {
    protected Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean isValid(String valueStr, ConstraintValidatorContext constraintValidatorContext) {
        log.info("isValid valueStr={}",valueStr);
        if(valueStr == null){
            log.info("value 不校验");
            return true;
        }
        if(valueStr.equals("1") || valueStr.equals("2")){
            log.info("value 校验失败");
            return false;
        }
        return true;
    }
}
