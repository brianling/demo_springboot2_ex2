package com.example.demo_springboot2_ex2.graphql.entity;

import com.example.demo_springboot2_ex2.graphql.entity.Animal;
import lombok.Data;

@Data
public class Monkey extends Animal{
    private Integer armSpanLength;
}
