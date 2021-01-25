package pl.sebastian.driver.service;

import org.springframework.stereotype.Service;
import pl.sebastian.driver.domain.Advice;
import pl.sebastian.driver.repository.AdviceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdviceService {

    private final AdviceRepository adviceRepository;

    public AdviceService(AdviceRepository adviceRepository) {
        this.adviceRepository = adviceRepository;
    }


    public Advice getAdviceById(Long id) {
        return adviceRepository.getOne(id);
    }

    public Advice findById(Long id){
        Optional<Advice> findAdvice = adviceRepository.findById(id);
        return findAdvice.get();
    }

    public List<Advice> all(){
        return adviceRepository.findAll();
    }

    public void delete(Advice advice){
        adviceRepository.delete(advice);
    }

    public Advice save(Advice advice){
        return adviceRepository.save(advice);
    }
}
