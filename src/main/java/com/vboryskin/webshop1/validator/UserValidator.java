package com.vboryskin.webshop1.validator;

import com.vboryskin.webshop1.dto.UserDTO;
import com.vboryskin.webshop1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidator implements ConstraintValidator<RegistrationValid, UserDTO> {
    @Override
    public void initialize(RegistrationValid constraintAnnotation) {

    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
        boolean isOk = true;
        if(userDTO.getEmail().isEmpty() ||
                userDTO.getUsername().isEmpty() ||
                userDTO.getPassword().isEmpty()){
            userDTO.setInvalidEmail(userDTO.getEmail().isEmpty()?"Email cannot be empty!":"");
            userDTO.setInvalidUsername(userDTO.getUsername().isEmpty()?"Username cannot be empty!":"");
            userDTO.setInvalidPassword(userDTO.getPassword().isEmpty()?"Password cannot be empty!":"");
            isOk = false;
        }
        if(!userDTO.getPassword().equals(userDTO.getRepeatPassword())){
            userDTO.setPasswordsDoNotMatch("Passwords do not match!");
            isOk =  false;
        }
        if(userRepository.existsUserByUsernameOrEmail(userDTO.getUsername(), userDTO.getEmail())){
            userDTO.setAlreadyExistsError("User with this username or email already exists!");
            isOk =  false;
        }
        return isOk;
    }
}
