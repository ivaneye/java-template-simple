package com.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

/**
 * Created by ivan on 15-1-22.
 */
public class SensitiveValidator implements ConstraintValidator<Sensitive,Object> {


    @Override
    public void initialize(Sensitive constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value == null) return true;
        if(value instanceof  String){
            //验证敏感词
        }else{
            Class clz = value.getClass();
            Method[] methods = clz.getMethods();
            for(Method m : methods){
                if(m.getReturnType() != String.class)continue;
                if(!m.getName().startsWith("get"))continue;
                //敏感词验证
            }
        }
        return false;
    }
}
