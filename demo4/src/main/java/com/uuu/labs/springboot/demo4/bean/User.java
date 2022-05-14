package com.uuu.labs.springboot.demo4.bean;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private String id;
    private String username;
    private String email;
}
