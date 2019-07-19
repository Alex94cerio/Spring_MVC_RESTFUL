package com.crud.springboot.backend.projectbackend.service.mapper;
import com.crud.springboot.backend.projectbackend.service.DTO.UserDTO;

import com.crud.springboot.backend.projectbackend.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring", uses = {}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {


    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
    List<UserDTO> userListToUserDTOList(List<User> users);
    List<User> userDTOListToUserList( List<UserDTO> usersDTO);

}
