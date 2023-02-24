package com.filyago.demo.service;

import com.filyago.demo.model.Tailor;
import com.filyago.demo.repository.TailorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  TailorService {
    private final TailorRepository tailorRepository;

    public TailorService(TailorRepository tailorRepository) {
        this.tailorRepository = tailorRepository;
    }

    public Optional<Tailor> getTailorById(Long id) {
        return tailorRepository.findById(id);
    }

    public List<Tailor> getAllTailors() {
        return tailorRepository.findAll();
    }

    public void putTailor(Tailor tailor){
        tailorRepository.save(tailor);
    }
    public void clearAll(){
        tailorRepository.deleteAll();
    }
    public void deleteTailor( Long id){
        tailorRepository.deleteById(id);
    }
    public boolean checkTailor(String username){
        List <String> theList = tailorRepository.findByUsername(username);
        if (theList.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
}