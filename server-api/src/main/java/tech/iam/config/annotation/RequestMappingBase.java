package tech.iam.config.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import tech.iam.controller.SodaController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
//@RequestMapping(path = {})
public @interface RequestMappingBase {
}
