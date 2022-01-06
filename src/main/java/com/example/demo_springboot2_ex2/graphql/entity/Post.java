package com.example.demo_springboot2_ex2.graphql.entity;

import com.example.demo_springboot2_ex2.graphql.data.MockData;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Post{

    
    private int id;
    private int authorId;
    private User author;
    private String title;
    private String content;
    private String createdAt;
    private int[] likeGiverIds;
    
    public User getAuthor(){
        for(User user : MockData.users){
            if(user.getId() == this.authorId){
                return user;
            }
        }
        //return MockData.users.stream().filter(u->u.getId()==this.getId()).findFirst().get();
        return null;
    }
    
    public List<User> likeGivers() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("BrianLing");
        user1.setAge(46);
        user1.setEmail("brianling0704@gmail.com");

        User user2 = new User();
        user2.setId(2);
        user2.setName("IreneLu");
        user2.setAge(39);
        user2.setEmail("irenelu@gmail.com");

        return Arrays.asList(user1, user2);
    }
    
    
}
