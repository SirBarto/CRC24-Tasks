package tech.iam.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.iam.dto.SodaDto;
import tech.iam.entity.Soda;
import tech.iam.service.SodaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@Tag(name="Soda controller")
public class SodaController {

    private static final String URL_SODA = "/v1/soda/";
    private static final String URL_SODA_ELEMENT = URL_SODA + "{sodaName:.+}";

    private final SodaService sodaService;

    @Autowired
    public SodaController(SodaService sodaService) {
        this.sodaService = sodaService;
    }

    @GetMapping(URL_SODA)
    public ResponseEntity<Page<SodaDto>> getAll(Pageable pageable){
        Page<Soda> allSoda = sodaService.getAllSoda(pageable);
        List<SodaDto> resultList = new ArrayList<>();
        allSoda.forEach(soda -> {
            var sodaDto = new SodaDto();
            sodaDto.setName(soda.getName());
            sodaDto.setCode(soda.getCode());
            sodaDto.setPrice(soda.getPrice());
            resultList.add(sodaDto);
        });
        return new ResponseEntity<>(new PageImpl<>(resultList, pageable, allSoda.getTotalElements()), HttpStatus.OK);
    }
    @GetMapping(URL_SODA_ELEMENT)
    public ResponseEntity<SodaDto> getSoda(@PathVariable String sodaName){
        var soda = sodaService.getSoda(sodaName);
        if(soda.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(soda.get(), HttpStatus.OK);
    }

    @PutMapping(URL_SODA)
    public ResponseEntity<SodaDto> createOrUpdateSoda(@RequestBody SodaDto sodaDto){
       var soda = sodaService.getSoda(sodaDto.getName());
       if(soda.isEmpty()){
           sodaService.addSoda(sodaDto);
       } else {
           sodaService.updateSoda(sodaDto);
       }
       return new ResponseEntity<>(sodaDto, HttpStatus.OK);
    }

    @DeleteMapping(URL_SODA_ELEMENT)
    public void deleteSoda(@PathVariable String sodaName){
        sodaService.deleteSoda(sodaName);
    }

}
