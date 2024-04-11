package tech.iam.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.iam.dto.UsersDto;
import tech.iam.service.UserService;

import java.security.Principal;

@RestController
@Tag(name="User controller")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get user details", description = "Get user details like name, roles and related pCodes")
    @GetMapping(path = "/v1/user")
    public UsersDto getUserDetails(Principal principal) {
        String username = principal.getName();
        return userService.getUserDetails(username);
    }

}
