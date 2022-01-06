package com.example.demo_springboot2_ex2.graphql.resolver.query;

import com.example.demo_springboot2_ex2.graphql.data.MockData;
import com.example.demo_springboot2_ex2.graphql.entity.User;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.scalars.ExtendedScalars;
import graphql.scalars.numeric.NonNegativeIntScalar;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserQueryResolver implements GraphQLQueryResolver{

    
    public String hello(){
        return "Hello World";
    }
    
    public User me(){
        return MockData.users.get(0);
    }
    
    public User user(String name){
        for(User user : MockData.users){
            if(user.getName().equals(name)){
                return user;
            }
        }
        
        return null;
    }
    
    public List<User> users() {
        return MockData.users;
    }
    
    @Bean
    public GraphQLScalarType date()
    {
        return ExtendedScalars.Date;
    }
    
    //@Bean
    //public GraphQLScalarType nonNegativeIntScalar()
    //{
    //    return NonNegativeIntScalar;
    //}

}
