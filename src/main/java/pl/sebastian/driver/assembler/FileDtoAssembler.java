package pl.sebastian.driver.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.sebastian.driver.DTO.FileDto;
import pl.sebastian.driver.domain.File;

@Component
public class FileDtoAssembler {

    private final ModelMapper modelMapper;

    public FileDtoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FileDto toDto(File file){
        FileDto fileDto = new FileDto();
        fileDto.setData(file.getData());
        fileDto.setFileName(file.getFileName());
        fileDto.setFileType(file.getFileType());
        fileDto.setId(file.getId());
        fileDto.setFileUri("http://localhost:8090/file/"+String.valueOf(file.getId()));
        return fileDto;
    }

    public File fromDto(FileDto fileDto){
        File file = modelMapper.map(fileDto, File.class);
        return file;
    }

}
