package com.example.demo_springboot2_ex2.graphql.entity.input;

import lombok.Data;

@Data
public class AddPostInput{
    private String title;
    private String content;
}
