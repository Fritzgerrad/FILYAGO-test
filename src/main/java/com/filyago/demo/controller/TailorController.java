package com.filyago.demo.controller;

import com.filyago.demo.dto.TailorDTO;
import com.filyago.demo.model.Tailor;
import com.filyago.demo.repository.TailorRepository;
import com.filyago.demo.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/tailor")
@RestController
public class TailorController {
    private final TailorService tailorService;
    private final TailorRepository tailorRepository;

    @Autowired
    public TailorController(TailorService tailorService,
                            TailorRepository tailorRepository) {
        this.tailorService = tailorService;
        this.tailorRepository = tailorRepository;
    }
    @GetMapping("/home")
    public String Home(){
        return "WELCOME TO TAILORS OF FILYAGO";
    }
    @GetMapping("/all_tailors")
    public @ResponseBody List<Tailor> getAllTailors(){
        return tailorService.getAllTailors();
    }

    @GetMapping(value = "/{id}",produces ="application/json")
    public @ResponseBody Optional<Tailor> getTailorById(@PathVariable Long id){
        return tailorService.getTailorById(id);
    }

    @PostMapping
    public ResponseEntity<Object> addTailor(@RequestBody TailorDTO tailorDTO){
        String username = tailorDTO.getUsername();
        if (tailorService.checkTailor(username)){
            tailorService.putTailor(Tailor.CREATE(tailorDTO));
            return new ResponseEntity<>("Successfully created",HttpStatusCode.valueOf(200));
        }
        else{
            return new ResponseEntity<>("This username has already been used",HttpStatusCode.valueOf(200));
        }

    }
    @GetMapping
    public String newTailor(){
        TailorDTO felix = new TailorDTO("Felix","John","FelicyJohn00",35,'M',"09098708094", "Nigerian");
        tailorService.putTailor(Tailor.CREATE(felix));
        TailorDTO anita = new TailorDTO("Anita","Best","anibest27",27,'F',"09032708094","Ghanian");
        tailorService.putTailor(Tailor.CREATE(anita));
        TailorDTO Ben = new TailorDTO("Ben","Bailey","BennyBailey3",33,'F',"09032708087","English");
        tailorService.putTailor(Tailor.CREATE(Ben));
        return "Added Felix John, Anita Best, Ben Bailey";

    }
    @GetMapping("/error")
    public String Error(){
        return "ERROR";
    }

    @DeleteMapping
    public String clearTailors(){
        tailorService.clearAll();
        return "ALL TAILORS SUCCESSFULLY DELETED";
    }
    @DeleteMapping({"{id}"})
    public void deletethis(@PathVariable Long id){
        tailorService.deleteTailor(id);
    }

}
