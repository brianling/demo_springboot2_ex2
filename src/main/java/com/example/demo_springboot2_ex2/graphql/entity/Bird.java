package com.example.demo_springboot2_ex2.graphql.entity;

import com.example.demo_springboot2_ex2.graphql.entity.Animal;
import lombok.Data;

@Data
public class Bird extends Animal{
    private Integer wingSpanLength;
}
