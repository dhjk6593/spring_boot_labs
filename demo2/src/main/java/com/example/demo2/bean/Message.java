package com.example.demo2.bean;


import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Value("-1")
    private int id;

    @Value("Simon")
    private String name;
}
