package com.example.demo_springboot2_ex2.graphql.resolver.query;

import com.example.demo_springboot2_ex2.graphql.data.MockData;
import com.example.demo_springboot2_ex2.graphql.entity.*;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.SchemaParserDictionary;
import graphql.scalars.ExtendedScalars;
import graphql.scalars.numeric.NonNegativeIntScalar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalQueryResolver implements GraphQLQueryResolver{
    
    public Animal animal(String name){
        return MockData.animals.stream()
                .filter(animal -> animal.getName().equals(name))
                .findFirst().orElse(null);
    }
    
    public List<Animal> animals(){
        return MockData.animals;
    }
    
    @Configuration
    public class SchemaParserConfig {
        
        @Bean
        public SchemaParserDictionary schemaParserDictionary() {
            return new SchemaParserDictionary()
                    .add(Bird.class).add(Monkey.class)
                    .add(Book.class).add(Author.class)
                    .add(NonNegativeIntScalar.class)
                    .add(ExtendedScalars.NonNegativeInt.getClass())
                    ;
        }
        
    }
}
