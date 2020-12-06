package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.AdviceDto;
import pl.sebastian.driver.domain.Advice;

@Component
public class AdviceDtoAssembler {


    private final ModelMapper modelMapper;

    public AdviceDtoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public AdviceDto toDto(Advice advice){
        AdviceDto adviceDto = modelMapper.map(advice, AdviceDto.class);
        return adviceDto;
    }

    public Advice fromDto(AdviceDto adviceDto){
        Advice advice = modelMapper.map(adviceDto,Advice.class);
        return advice;
    }
}
