package com.crud.springboot.backend.projectbackend.controller;


import com.crud.springboot.backend.projectbackend.exception.ResourceNotFoundException;
import com.crud.springboot.backend.projectbackend.model.User;
import com.crud.springboot.backend.projectbackend.repository.UserRepository;
import com.crud.springboot.backend.projectbackend.service.DTO.UserDTO;
import com.crud.springboot.backend.projectbackend.service.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ( "/api/users" )
public class UserController {

    private final UserRepository userRepository;
    private UserMapper userMapper;

    public UserController(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok().body(userRepository.save(user));
    }


    @GetMapping( "" )
    public ResponseEntity<List<UserDTO>>getAllUsers(){
        return ResponseEntity.ok().body(userMapper.userListToUserDTOList(
                userRepository.findAll()));
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<UserDTO>  getUserById(@PathVariable(value = "id") Long userId)
        throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow( () -> new ResourceNotFoundException("User not found with id :: " +  userId));
        return ResponseEntity.ok().body(userMapper.userToUserDTO(user));
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateEmployee(@PathVariable(value = "id") Long userId,
                                                   @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :: " + userId));

        user.setSkillList(userDetails.getSkillList());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        user.setRole(userDetails.getRole());
        user.setMaritalStatus(userDetails.getMaritalStatus());
        user.setCountry(userDetails.getCountry());
        user.setBirthdate(userDetails.getBirthdate());
//        user.setFileName(userDetails.getFileName());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(userMapper.userToUserDTO(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity< Map<String, Boolean> > deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :: " + employeeId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Map>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        Map<String, Map> result = new HashMap<>();
        result.put("errors", errors);
        return ResponseEntity.ok().body(result);
    }
}



