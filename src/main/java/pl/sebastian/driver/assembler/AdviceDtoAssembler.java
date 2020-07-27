package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.AdviceDto;
import pl.sebastian.driver.domain.Advice;

@Component
public class AdviceDtoAssembler {

    private ModelMapper modelMapper;

    public AdviceDto toDto(Advice advice){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        AdviceDto adviceDto = modelMapper.map(advice, AdviceDto.class);
        return adviceDto;
    }

    public Advice fromDto(AdviceDto adviceDto){
        Advice advice = new Advice();
        advice.setId(adviceDto.getId());
        advice.setContent(adviceDto.getContent());
        return advice;
    }
}
