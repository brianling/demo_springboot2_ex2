package com.example.demo_springboot2_ex2.graphql.data;

import com.example.demo_springboot2_ex2.graphql.entity.*;

import java.util.ArrayList;
import java.util.List;

public class MockData{
    public static List<User> users;
    public static List<Post> posts;
    public static List<Animal> animals;
    public static List<Author> authors;
    public static List<Book> books;
    
    static {
        users = new ArrayList<>();
    
        users.add(new User(){{
            setId(1);
            setName("Fong");
            setAge(23);
            setFriendIds(new int[]{2, 3});
            setHeightCentimeter(175F);
            setHeightMetre(1.75F);
            setHeightFoot(5.741469816272966F);
            setWeightKilogram(70F);
            setWeightgram(7000F);
            setWeightPound(154.3235835294143F);
        }});
    
        users.add(new User(){{
            setId(2);
            setName("Kevin");
            setAge(40);
            setFriendIds(new int[]{1});
            setHeightCentimeter(185F);
            setHeightMetre(1.85F);
            setHeightFoot(6.069553805774278F);
            setWeightKilogram(90F);
            setWeightgram(9000F);
            setWeightPound(198.4160359663898F);
        }});
    
        users.add(new User(){{
            setId(3);
            setName("Mary");
            setAge(18);
            setFriendIds(new int[]{1});
            setHeightCentimeter(162F);
            setHeightMetre(1.62F);
            setHeightFoot(5.31496062992126F);
            setWeightKilogram(null);
            setWeightgram(0F);
            setWeightPound(0F);
        }});
    }
    
    static {
        posts = new ArrayList<>();
        posts.add(new Post(){{
            setId(1);
            setAuthorId(1);
            setTitle("Hello World!");
            setContent("This is my first post.");
            setLikeGiverIds(new int[]{1});
        }});
    
        posts.add(new Post(){{
            setId(2);
            setAuthorId(2);
            setTitle("Good Night");
            setContent("Have a Nice Dream =)");
            setLikeGiverIds(new int[]{2,3});
        }});
    
        posts.add(new Post(){{
            setId(3);
            setAuthorId(3);
            setTitle("I Love U");
            setContent("Here's my second post!");
            setLikeGiverIds(new int[]{});
        }});
    }
    
    static {
        animals = new ArrayList<>();
        
        animals.add(new Bird(){{
            setName("Chiken Litte");
            setWingSpanLength(10);
        }});
    
        animals.add(new Monkey(){{
            setName("Goku");
            setArmSpanLength(20);
        }});
    
        animals.add(new Monkey(){{
            setName("King Kong");
            setArmSpanLength(200);
        }});
    }
    
    static{
        authors = new ArrayList<>();
        
        authors.add(new Author(){{
            setName("John");
        }});
        authors.add(new Author(){{
            setName("Mary");
        }});
    }
    
    static{
        books = new ArrayList<>();
        books.add(Book.builder().title("Journey to the West").build());
        books.add(Book.builder().title("Mary Loves Me").build());
    }
    
}
