package lb.spring.test;

import lb.spring.controllers.UserController;
import lb.spring.dto.UserDto;



import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;


import javax.mail.MessagingException;


import static junit.framework.TestCase.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests  {
    @Autowired
    UserController userService;

    UserDto userDto=new UserDto();
    @Test
    public void testAddUser() throws MessagingException {
        assertNotNull(userService.addUserWithoutImage(userDto));
    }
  /*  @Test
    public void testAddUserWithImage() throws IOException, JSONException {
        MockMultipartFile image
                = new MockMultipartFile(
                "image",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello, World!".getBytes()
        );

        JSONObject userDto=new JSONObject("{\n" +
                "    \"firstName\":\"elkilani\",\n" +
                "    \"lastName\":\"elkarous\",\n" +
                "    \"role\":\"SUPER_ADMIN\",\n" +
                "    \"password\":\"admin\",\n" +
                "    \"email\":\"admin@lb.tn\"\n" +
                "\n" +
                "}");
        assertNotNull(userService.addUser(userDto.toString(),null));
    }*/


    @Test
    public void testGetAllUsers() {
assertNotNull(userService.getAllUsers());
    }

    @Test
    public void testSendEmail()throws MessagingException {

       assertNotNull(userService.sendHtmlEmail("elkilani@hotmail.fr"));
    }


    @After
    public void testGetUserByEmail() {
        assertNotNull(userService.getUserByEmail("elkilani@hotmail.fr") );
    }






}
