package com.example.demo_springboot2_ex2.graphql.entity;

import com.example.demo_springboot2_ex2.graphql.data.MockData;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class Book{
    private String title;
    
    public List<Book> search(String contains){
        List<Book> result = new ArrayList<>();
        //result.addAll(MockData.authors.stream().filter(author -> author.getName().contains(contains)).collect(Collectors.toList()));
        result.addAll(MockData.books.stream().filter(book -> book.getTitle().contains(contains)).collect(Collectors.toList()));
        
        return result;
    }
}
