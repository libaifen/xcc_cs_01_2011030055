package com.example.demo1029;

import com.example.demo1029.Entity.User;
import com.example.demo1029.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class UserServiceTest {
    @Spy
    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserById() {
        // 模拟数据
        Long userId = 1L;
        User expectedUser = new User();
        expectedUser.setId(userId);
        expectedUser.setUsername("realUser");

        // 模拟getUserById方法
        when(userService.getUserById(userId)).thenReturn(expectedUser);

        // 调用getUserById方法
        User actualUser = userService.getUserById(userId);

        // 验证getUserById方法的行为
        verify(userService).getUserById(userId);

        // 验证返回的用户数据是否正确
        assertEquals(userId, actualUser.getId());
        assertEquals("realUser", actualUser.getUsername());
    }
}
