package com.lespania.implementation;

import com.lespania.mapper.MapperUtil;
import com.lespania.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    MapperUtil mapperUtil;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void deleteByUserName() {
        userService.deleteByUserName("mike@cybertek.com");

        //        verify(userRepository).deleteByUserName("mike@cybertek.com");
        verify(userRepository,times(2)).deleteByUserName("mike@cybertek.com");
        verify(userRepository,atLeastOnce()).deleteByUserName("mike@cybertek.com");
        verify(userRepository,atMost(5)).deleteByUserName("mike@cybertek.com");
    }
}