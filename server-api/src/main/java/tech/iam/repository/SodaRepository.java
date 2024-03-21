package tech.iam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.iam.entity.Soda;

import java.util.List;
import java.util.Optional;

@Repository
public interface SodaRepository extends JpaRepository<Soda, Integer> {

    Optional<Soda> findSodaByIdSoda(int id);
    Optional<Soda> findSodaByName(String name);
    List<Soda> findAll();

}
