package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.FileDto;
import pl.sebastian.driver.domain.File;

@Component
public class FileDtoAssembler {

    private ModelMapper modelMapper;

    public FileDto toDto(File file){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        FileDto fileDto = modelMapper.map(file, FileDto.class);
        return fileDto;
    }

    public File fromDto(FileDto fileDto){
        File file = new File();
        file.setId(String.valueOf(fileDto.getId()));
        file.setFileName(fileDto.getFileName());
        file.setFileType(fileDto.getFileType());
        file.setData(fileDto.getData());
        return file;
    }

}
