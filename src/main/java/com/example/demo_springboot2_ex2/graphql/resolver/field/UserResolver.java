package com.example.demo_springboot2_ex2.graphql.resolver.field;

import com.example.demo_springboot2_ex2.graphql.data.MockData;
import com.example.demo_springboot2_ex2.graphql.entity.Post;
import com.example.demo_springboot2_ex2.graphql.entity.User;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * field resolver
 */
@Component
public class UserResolver implements GraphQLResolver<User>{
    
    public List<Post> posts(User user){
        List<Post> posts = MockData.posts.stream()
                .filter(post->post.getAuthorId() == user.getId())
                .collect(Collectors.toList());

        return posts;
    }
    
    public List<User> friends(User user) {
        
        if(user.getName().equals("Fong")){
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
    
}
