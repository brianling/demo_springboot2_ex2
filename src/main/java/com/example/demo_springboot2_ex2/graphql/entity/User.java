package com.example.demo_springboot2_ex2.graphql.entity;


import com.example.demo_springboot2_ex2.graphql.data.MockData;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class User{
    
    private int id;
    private String email;
    private String name;
    private Integer age;
    private String birthDay;
    private Float heightCentimeter;
    private Float heightMetre;
    private Float heightFoot;
    private Float weightKilogram;
    private Float weightgram;
    private Float weightPound;
    private int[] friendIds;
    
    public Float height(HeightUnit heightUnit){
        switch(heightUnit){
            case CENTIMETRE:
                return this.heightCentimeter;
            case METRE:
                return this.heightMetre;
            case FOOT:
                return this.heightFoot;
        }
        
        return null;
    }
    
    public Float weight(WeightUnit weightUnit){
        switch(weightUnit){
            case KILOGRAM:
                return this.weightKilogram;
            case GRAM:
                return this.weightgram;
            case POUND:
                return this.weightPound;
        }
        
        return null;
    }
    
    public List<User> friends() {
        
        if(this.name.equals("Fong")){
            User user1 = new User();
            user1.setId(2);
            user1.setName("Kevin");
            user1.setAge(40);

            User user2 = new User();
            user2.setId(3);
            user2.setName("Mary");
            user2.setAge(18);

            return Arrays.asList(user1, user2);
        }
        else{
            User user1 = new User();
            user1.setId(1);
            user1.setName("Fong");
            user1.setAge(23);
            
            return Arrays.asList(user1);
        }
    }
    
    public List<Post> posts() {
        List<Post> result =
                MockData.posts.stream()
                        .filter(post -> post.getAuthorId() == this.id)
                        .collect(Collectors.toList());

        return result;
    }

}


