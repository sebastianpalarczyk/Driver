package pl.sebastian.driver.service;

import org.springframework.stereotype.Service;
import pl.sebastian.driver.repository.AdviceRepository;

@Service
public class AdviceService {

    private final AdviceRepository adviceRepository;

    public AdviceService(AdviceRepository adviceRepository) {
        this.adviceRepository = adviceRepository;
    }
}
