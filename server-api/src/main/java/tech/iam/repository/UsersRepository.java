package tech.iam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.iam.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    public Users findUserByUsername(String username);
}
