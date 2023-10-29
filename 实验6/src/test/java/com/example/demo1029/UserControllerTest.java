package com.example.demo1029;

import com.example.demo1029.Entity.User;
import com.example.demo1029.controller.UserController;
import com.example.demo1029.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        // 初始化模拟对象
        MockitoAnnotations.initMocks(this);
        // 构建MockMvc实例
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testGetUserById() throws Exception {
        // 创建一个模拟用户
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setUsername("mockUser");

        // 模拟Service层的getUserById方法，返回模拟用户
        when(userService.getUserById(1L)).thenReturn(mockUser);

        // 封装controller请求、执行Controller请求并验证基础响应数据和具体响应数据
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk()) // 基础响应数据：预期HTTP状态码为200 OK
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // 基础响应数据：预期内容类型为JSON
                .andExpect(jsonPath("$.id", is(1))) // 具体响应数据：预期JSON响应中的id字段为1
                .andExpect(jsonPath("$.username", is("mockUser"))); // 具体响应数据：预期JSON响应中的username字段为"mockUser"
    }
}

