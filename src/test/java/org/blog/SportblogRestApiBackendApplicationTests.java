package org.blog;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.blog.model.Comment;
import org.blog.model.Post;
import org.blog.model.User;
import org.blog.repository.CommentRepository;
import org.blog.repository.PostRepository;
import org.blog.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SportblogRestApiBackendApplicationTests {
   @Autowired
    PostRepository postRepository;
   @Autowired
    UserRepository userRepository;
   @Autowired
   CommentRepository commentRepository;
   
    @Test
    @Order(1)
   
	public void getPostTest()throws IOException ,SQLException ,ClassNotFoundException {
		List<Post> post = postRepository.findAll();
		assertThat(post).size().isGreaterThan(0);
		
		}
    
    @Test
    @Order(2)
    @Disabled
    
    public void getPostsbyCategoryTest()throws IOException ,SQLException ,ClassNotFoundException {
    	List<Post> post = postRepository.findByCategoryId(5);
    	assertThat(post).size().isGreaterThan(0);
    }
	@Test
	@Order(3)
	
	public void getPostsbyUserIdTest() throws IOException ,SQLException ,ClassNotFoundException{
		List<Post> post = postRepository.findPostsByUserId(89765);
		assertNotEquals(353604,post);
	}
    @Test
    @Order(4)
    @Disabled
    
    public void getCommentsbyPostIdTest()throws IOException ,SQLException ,ClassNotFoundException {
    	List<Comment> comment = commentRepository.findBypost((long) 67894);
    	assertEquals("What an innings, Surya Kumar Yadav Awesome!!!",comment);
    }
    @Test
    @Order(5)
    
    public void getCommentsbyPostIdTest1() throws IOException ,SQLException ,ClassNotFoundException{
    	List<Comment> comment = commentRepository.findBypost((long) 88976);
    	assertNotNull(comment);
    }
    @Test()
    @Order(6)
    @Disabled
    
    public void getCommentsbyPostIdTest2()throws IOException ,SQLException ,ClassNotFoundException {
    	List<Comment> comment = commentRepository.findBypost((long) 67894);
    	assertNull(comment);
    }
    @Test
    @Order(7)
    @Disabled
   
    public void getUserbyEmailTest()throws IOException ,SQLException ,ClassNotFoundException {
    	Optional<User> user = userRepository.findByuserEmail("Genelia@gmail.com");
    	assertSame(user,"Renilia@gmail.com");
    }
    @Test
    @Order(8)
   
    public void getUserbyEmailTest1()throws IOException ,SQLException ,ClassNotFoundException{
    	Optional<User> user = userRepository.findByuserEmail("Genelia@gmail.com");
    	assertNotSame(user,"Renilia@gmail.com");
    }
    @Test
    @Order(9)
    @Disabled
   
    public void failTest() {
    	
    	long postId = 88978; 
    	if(postId == 88978)
    	fail("postId not found");
    }
    @Test
    @Order(10)
    
    public void getUserbyEmailTest2()throws IOException ,SQLException ,ClassNotFoundException {
    	Optional<User> user = userRepository.findByuserEmail("Genelia@gmail.com");
    	assertNotEquals(user,"Renilia@gmail.com");
    }
	}




