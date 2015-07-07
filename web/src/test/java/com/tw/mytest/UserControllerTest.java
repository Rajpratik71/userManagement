package com.tw.mytest;

import com.tw.core.User;
import com.tw.core.service.PasswordService;
import com.tw.core.service.UserService;
import com.tw.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by chenbojian on 15-7-7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:test-spring.xml"})
public class UserControllerTest {
    @Mock
    private UserService userService;

    @Mock
    private PasswordService passwordService;

    @InjectMocks
    UserController userController = new UserController(userService, passwordService);

    private MockMvc mockMvc;
    List<User> users = new ArrayList<User>(0);
    User user;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

//        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        user = new User();
        user.setEmail("test@test.com");
        user.setId(1);
        user.setName("test");
        user.setAge(18);
        user.setPassword("password");
        users.add(user);
    }

    @Test
    public void when_visit_root_should_insert_users_in_model() throws Exception {
        when(userService.listUser()).thenReturn(users);
        ModelAndView modelAndView = userController.listOfUsers();
        List<User> users = (List<User>) modelAndView.getModel().get("users");
        assertThat(users.get(0).getName()).isEqualTo("test");
        assertThat(users.get(0).getId()).isEqualTo(1L);
        verify(userService, times(1)).listUser();
    }

    @Test
    public void when_post_add_should_add_success() throws Exception {
        userController.addUser(user);
        verify(userService).addUser(any(User.class));
    }
}
