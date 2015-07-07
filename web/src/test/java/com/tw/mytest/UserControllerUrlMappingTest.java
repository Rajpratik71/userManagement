package com.tw.mytest;

import com.tw.core.User;
import com.tw.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by chenbojian on 15-7-7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:test-spring.xml"})
public class UserControllerUrlMappingTest {
    @Mock
    private UserController userController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void when_visit_root_should_call_listOfUsers() throws Exception {
        mockMvc.perform(get("/user/"));
        verify(userController,times(1)).listOfUsers();
    }

    @Test
    public void when_post_add_should_call_addUser() throws Exception {
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        RequestBuilder requestBuilder = post("/user/add")
                .param("id", "1")
                .param("name", "test")
                .param("email", "test@test.com")
                .param("age", "18")
                .param("password", "password");

        this.mockMvc.perform(requestBuilder);
        verify(userController).addUser(argument.capture());
        assertThat(argument.getValue().getName()).isEqualTo("test");
        assertThat(argument.getValue().getId()).isEqualTo(1L);
        assertThat(argument.getValue().getEmail()).isEqualTo("test@test.com");


    }
}
