package com.example.demo_springboot2_ex2.graphql.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import graphql.kickstart.tools.SchemaParserOptions;
import graphql.scalars.ExtendedScalars;
import graphql.scalars.numeric.NonNegativeIntScalar;
import graphql.schema.GraphQLScalarType;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScalarConfig{
    
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    
    @Bean
    public SchemaParserOptions schemaParserOptions() {
        return SchemaParserOptions.newOptions()
                .objectMapperProvider(fieldDefinition -> objectMapper()).build();
    }
    
    @Bean
    public GraphQLScalarType nonNagetiveInt(){
        //RuntimeWiring.newRuntimeWiring().scalar(ExtendedScalars.NonNegativeInt);
        return ExtendedScalars.NonNegativeInt;
    }
}
