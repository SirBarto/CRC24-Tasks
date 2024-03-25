package tech.iam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.iam.entity.Soda;

import java.util.List;
import java.util.Optional;

@Repository
public interface SodaRepository extends JpaRepository<Soda, Integer> {

    Optional<Soda> findSodaByIdSoda(int id);
    Optional<Soda> findSodaByName(String name);

    List<Soda> findSodaByCodeAndPrice(String code, String price);

    @Query(value = "SELECT s FROM Soda s WHERE s.idSoda =:id")
    Optional<Soda> findSodaWithId(int id);

//    @Query(value = "SELECT * FROM Soda s WHERE s.id_soda =:id",nativeQuery = true)
//    Optional<Soda> findSodaWithId2(int id);
//
    List<Soda> findAll();

}
