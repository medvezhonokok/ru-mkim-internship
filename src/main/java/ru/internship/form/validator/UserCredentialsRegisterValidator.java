package ru.internship.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.internship.form.UserCredentials;
import ru.internship.service.UserService;

@Component
public class UserCredentialsRegisterValidator implements Validator {
    private final UserService userService;
    public UserCredentialsRegisterValidator(UserService userService) {
        this.userService = userService;
    }

    public boolean supports(Class<?> clazz) {
        return UserCredentials.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            UserCredentials registerForm = (UserCredentials) target;
            if (!userService.isLoginFree(registerForm.getLogin())) {
                errors.rejectValue("login", "login.is-in-use", "Login is in use already");
            }
        }
    }
}
