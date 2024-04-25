package tech.iam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.iam.dto.SodaDto;
import tech.iam.entity.Soda;
import tech.iam.exception.SodaNotFoundException;
import tech.iam.repository.SodaRepository;

import java.util.Optional;
import java.util.random.RandomGenerator;

@Service
@Transactional
public class SodaService {

    private final SodaRepository sodaRepository;

    @Autowired
    public SodaService(SodaRepository sodaRepository) {
        this.sodaRepository = sodaRepository;
    }

    public Optional<SodaDto> getSoda(String name) {
        Optional<Soda> soda = sodaRepository.findSodaByName(name);
        SodaDto dto = new SodaDto();
        if (soda.isPresent()) {
            dto.setName(soda.get().getName());
            dto.setCode(soda.get().getCode());
            dto.setPrice(soda.get().getPrice());
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }

    public Page<Soda> getAllSoda(Pageable pageable) {
        return sodaRepository.findAll(pageable);
    }

    public void addSoda(SodaDto sodaDto) {
        int id = RandomGenerator.getDefault().nextInt();
        Soda soda = new Soda(id, sodaDto.getName(), sodaDto.getCode(), sodaDto.getPrice());
        sodaRepository.save(soda);
    }

    public void updateSoda(SodaDto oldSodaDto, SodaDto updatedSodaDto) {
        Optional<Soda> soda = sodaRepository.findSodaByName(oldSodaDto.getName());
        if (soda.isPresent()) {
            soda.get().setName(updatedSodaDto.getName());
            soda.get().setCode(updatedSodaDto.getCode());
            soda.get().setPrice(updatedSodaDto.getPrice());
            sodaRepository.save(soda.get());
        }
    }

    public void deleteSoda(String name) {
        var sodaByName = sodaRepository.findSodaByName(name);
        if (sodaByName.isEmpty()) {
            throw new SodaNotFoundException(name);
        }
        sodaRepository.delete(sodaByName.get());

    }

//    public void addOrUpdatePurpose(SodaDto sodaDto) {
//        var soda = getSoda(sodaDto.getName());
//        if (soda.isEmpty()) {
//            addSoda(sodaDto);
//        } else {
//            updateSoda(sodaDto);
//        }
//    }

    //@Transactional
    public void safe(){
        Soda soda = new Soda();
        soda.setIdSoda(10);
        soda.setName("Tyskie");
        soda.setCode("TYSKIE");
        soda.setPrice("3.5");
        sodaRepository.save(soda);
      //  System.out.println(10/0);
    }

    public Optional<Soda> findSoda(){
        int id =2;
        return sodaRepository.findSodaWithId(id);
    }

}
