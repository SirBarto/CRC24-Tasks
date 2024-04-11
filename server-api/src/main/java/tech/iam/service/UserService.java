package tech.iam.service;

import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tech.iam.dto.UsersDto;
import tech.iam.repository.UsersRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Service
public class UserService {

    private final UsersRepository usersRepository;


    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersDto getUserDetails(String username){
        List<String> authorites = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return new UsersDto(username,authorites, Collections.emptyList());
    }

}
