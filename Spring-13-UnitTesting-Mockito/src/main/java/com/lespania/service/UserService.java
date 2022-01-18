package com.lespania.service;

import com.lespania.dto.UserDTO;
import com.lespania.entity.User;
import com.lespania.exception.TicketingProjectException;

import java.util.List;

public interface UserService {

    List<UserDTO> listAllUsers();

    UserDTO findByUserName(String username);

    void save(UserDTO dto);

    UserDTO update(UserDTO dto);

    void delete(String username) throws TicketingProjectException;

    void deleteByUserName(String username);

    List<UserDTO> listAllByRole(String role);

    Boolean checkIfUserCanBeDeleted(User user);

}
