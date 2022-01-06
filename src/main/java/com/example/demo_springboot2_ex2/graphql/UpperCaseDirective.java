package com.example.demo_springboot2_ex2.graphql;

import graphql.schema.*;
import graphql.schema.idl.SchemaDirectiveWiring;
import graphql.schema.idl.SchemaDirectiveWiringEnvironment;

import java.util.Map;

/**
 * https://www.graphql-java.com/documentation/v16/sdl-directives/
 */
public class UpperCaseDirective implements SchemaDirectiveWiring{
    
    @Override
    public GraphQLFieldDefinition onField(SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> environment) {
        GraphQLFieldDefinition field = environment.getElement();
        GraphQLFieldsContainer parentType = environment.getFieldsContainer();
        DataFetcher originalDataFetcher = environment.getCodeRegistry().getDataFetcher(parentType, field);
        DataFetcher authDataFetcher = new DataFetcher() {
            @Override
            public Object get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
                Map<String, Object> contextMap = dataFetchingEnvironment.getContext();
                String value = (String)originalDataFetcher.get(dataFetchingEnvironment);
                if (value == null) {
                    return null;
                } else {
                    return value.toUpperCase();
                }
            }
        };
        
        // now change the field definition to have the new authorising data fetcher
        environment.getCodeRegistry().dataFetcher(parentType, field, authDataFetcher);
        return field;
    }
    
}
