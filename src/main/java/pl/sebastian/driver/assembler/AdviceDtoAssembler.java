package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.AdviceDto;
import pl.sebastian.driver.domain.Advice;
import pl.sebastian.driver.service.AdviceService;

@Component
public class AdviceDtoAssembler {

    private ModelMapper modelMapper;
    private final AdviceService adviceService;

    public AdviceDtoAssembler(AdviceService adviceService) {
        this.adviceService = adviceService;
    }


    public AdviceDto toDto(Advice advice){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        AdviceDto adviceDto = modelMapper.map(advice, AdviceDto.class);
        return adviceDto;
    }

    public Advice fromDto(AdviceDto adviceDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Advice advice = modelMapper.map(adviceDto,Advice.class);
        if(adviceDto.getId() != 0){
            Advice oldAdvice = adviceService.getAdviceById(adviceDto.getId());
            advice.setId(oldAdvice.getId());
        }
        return advice;
    }
}
