package com.example.demo_springboot2_ex2.graphql.resolver.mutation;

import com.example.demo_springboot2_ex2.graphql.entity.input.AddPostInput;
import com.example.demo_springboot2_ex2.graphql.data.MockData;
import com.example.demo_springboot2_ex2.graphql.entity.Post;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class UserMutationResolver implements GraphQLMutationResolver{

    
    public Post addPost(String title, String content){
        int authorId = 1;
        Post post = new Post(){{
            setId(MockData.posts.size()+1);
            setAuthorId(authorId);
            setTitle(title);
            setContent(content);
        }};
    
        MockData.posts.add(post);
        
        return post;
    }
    
    public Post addPost(AddPostInput input){
        return this.addPost(input.getTitle(), input.getContent());
    }
    
    public Post likePost(int postId){
        for(Post post : MockData.posts){
            if(post.getId() == postId){
                MockData.posts.remove(post);
                return post;
            }
        }
        
        return null;
    }
}
