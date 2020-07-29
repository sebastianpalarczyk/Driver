package pl.sebastian.driver.service;

import org.springframework.stereotype.Service;
import pl.sebastian.driver.domain.Advice;
import pl.sebastian.driver.repository.AdviceRepository;

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

    public Advice save(Advice advice){
        return adviceRepository.save(advice);
    }

    public Advice create(){
        Advice advice = new Advice();
        advice.setId(1L);
        advice.setContent("Najlepsza porada");
        return advice;
    }

    public Advice replace(Advice advice){
        advice.setContent("Good advice");
        return advice;
    }
}
