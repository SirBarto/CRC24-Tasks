package tech.iam.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import tech.iam.dto.SodaDto;
import tech.iam.entity.Soda;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
@ActiveProfiles(profiles = "test")
class SodaServiceTest {

    @Autowired
    private SodaService sodaService;

    SodaDto sodaDto = new SodaDto();

    @BeforeEach
    void setUp(){
        sodaDto.setName("Soda testowa");
        sodaDto.setCode("SODA_TESTOWA");
        sodaDto.setPrice("12.0");
    }

    @AfterEach
    void cleaner(){
        sodaService.deleteSoda(sodaDto.getName());
    }

    @Test
    void getAllSoda(){
        //given
        var EXPECTED_SIZE = 7;

        //when
        Page<Soda> allSoda = sodaService.getAllSoda(Pageable.ofSize(10));

        //then
        assertEquals(EXPECTED_SIZE, allSoda.getTotalElements());
    }

    @Test
    void addSoda(){
        //given
        //when
        sodaService.addSoda(sodaDto);

        //then
        Optional<SodaDto> soda  = sodaService.getSoda(sodaDto.getName());
        assertTrue(soda.isPresent());
    }

    @Test
    void updateSoda(){
        //given
        var EXPECTED_SODA = "Soda testowa_2";
        sodaService.addSoda(sodaDto);
        var newSoda = sodaService.getSoda(sodaDto.getName());

        //when
        newSoda.get().setName(EXPECTED_SODA);
        sodaService.updateSoda(sodaDto, newSoda.get());
        var updatedSoda = sodaService.getSoda(newSoda.get().getName());

        //then
        assertEquals(EXPECTED_SODA, updatedSoda.get().getName());
    }

}