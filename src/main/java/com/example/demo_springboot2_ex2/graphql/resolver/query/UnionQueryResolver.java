package com.example.demo_springboot2_ex2.graphql.resolver.query;

import com.example.demo_springboot2_ex2.graphql.data.MockData;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UnionQueryResolver implements GraphQLQueryResolver{
    public List<Object> search(String contains){
        List<Object> result = new ArrayList<>();
        
        //我以為會自動做篩選，看來還是要自己實作
        //result.addAll(MockData.authors);
        //result.addAll(MockData.books);
        
        result.addAll(MockData.authors.stream().filter(author -> author.getName().contains(contains)).collect(Collectors.toList()));
        result.addAll(MockData.books.stream().filter(book -> book.getTitle().contains(contains)).collect(Collectors.toList()));
        
        return result;
    }
}
