package com.uuu.labs.springboot.demo4;

import com.uuu.labs.springboot.demo4.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class MyRunner3 implements CommandLineRunner {

    @Autowired
    JdbcTemplate template;

    private static final String DROP_DDL = "DROP TABLE USERS IF EXISTS";
    private static final String CREATE_DDL = "CREATE TABLE USERS(id SERIAL, username VARCHAR(225), email VARCHAR(225))";
    private static final String[] USER_INFO = {"Mark mark@abc.com", "Louis Louis@hotmail.com", "Ella ella@gmail.com"};
    private static final String[] USER_INFO2 = {"Abby abby@abc.com", "Mary Mary@hotmail.com", "Tiff tiff@gmail.com"};
    private static final String INSERT = "INSERT INTO USERS(username, email) VALUES(?,?)";
    private static final String SELECT_ALL = "SELECT * FROM USERS";

    @Override
    public void run(String... args) throws Exception {
        template.execute(DROP_DDL);
        template.execute(CREATE_DDL);
        applySQL1();
        applySQL2();
        applySQL3();
    }

    private void applySQL1() {
        List<Object[]> userInfo = Arrays.asList(USER_INFO).stream()
                .map(new Function<String, String[]>() {
                    @Override
                    public String[] apply(String s) {
                        return s.split(" ");
                    }
                }).collect(Collectors.toList());
        userInfo.forEach(new Consumer<Object[]>(){
            @Override
            public void accept(Object[] objects) {
                log.info("insert user for name:{}, email:{}", objects[0], objects[1]);
            }
        });
        template.batchUpdate(INSERT, userInfo);
    }

    private void applySQL2() {
        List<Object[]> userInfo = Arrays.asList(USER_INFO2).stream()
                .map(userInfoString -> userInfoString.split(" ")).collect(Collectors.toList());
        userInfo.forEach(info ->{
            log.info("insert user for name:{}, email:{}", info[0], info[1]);
        });
        template.batchUpdate(INSERT, userInfo);
    }

    private void applySQL3() {
        template.query(SELECT_ALL, (rs, row)-> {
            log.info("process rs{}, {} with row = {}", rs.getString("username"), rs.getString("email"), row);
            return new User(row+"",rs.getString("username"), rs.getString("email"));
        }).forEach(user -> {
            log.info("query user: {}", user);
        });
    }
}
