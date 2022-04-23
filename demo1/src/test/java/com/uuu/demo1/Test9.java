package com.uuu.demo1;

import com.uuu.demo1.beans.User2;
import com.uuu.demo1.beans.User3;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Test9 {

    private static Validator validator;
    //private static final Logger LOGGER = LoggerFactory.getLogger(Test8.class.getSimpleName());
    @BeforeAll
    public static void setupValidatorInstance(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    @Test
    public void test1(){
        User3 u2 = new User3("John");
        validator.validate(u2);
        Set<ConstraintViolation<User3>> violations = validator.validate(u2);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void test2(){
        User3 u2 = new User3("");
        Set<ConstraintViolation<User3>> violations = validator.validate(u2);
        for(ConstraintViolation<User3> violation : violations) {
            log.info("user={}, violation message={}", u2, violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void test3(){
        User3 u2 = new User3(null);
        Set<ConstraintViolation<User3>> violations = validator.validate(u2);
        for(ConstraintViolation<User3> violation: violations){
            log.info("Error: {}", violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void test4(){
        User3 u2 = new User3("   ");
        Set<ConstraintViolation<User3>> violations = validator.validate(u2);
        for(ConstraintViolation<User3> violation: violations){
            log.info("Error: {}", violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(1);
    }
}
