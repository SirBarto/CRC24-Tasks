package tech.iam.config.annotation;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@RestController
@RequestMappingBase
@PreAuthorize(SecuredRestController.ADMIN_ROLE)
public @interface SecuredRestController {

    String ADMIN_ROLE = "hasAuthority('admin')";
    String USER_ROLE = "hasAuthority('user')";
    String AUDITOR_ROLE = "hasAuthority('role_viewer')";

}
