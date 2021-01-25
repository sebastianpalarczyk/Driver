package pl.sebastian.driver.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.sebastian.driver.DTO.FileDto;
import pl.sebastian.driver.assembler.FileDtoAssembler;
import pl.sebastian.driver.domain.File;
import pl.sebastian.driver.repository.FileRepository;
import pl.sebastian.driver.service.FileService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

    private final FileService fileService;
    private final FileDtoAssembler fileDtoAssembler;

    public FileController(FileService fileService, FileDtoAssembler fileDtoAssembler, FileRepository fileRepository) {
        this.fileService = fileService;
        this.fileDtoAssembler = fileDtoAssembler;
    }

    @PostMapping(value = "/file")
    public FileDto create(@RequestParam("file") MultipartFile multipartFile) {
        return fileDtoAssembler.toDto(fileService.storeFile(multipartFile));
    }

    @GetMapping(value = "/file")
    public List<FileDto> all(){
        return fileService.all()
                .stream().map(file -> fileDtoAssembler.toDto(file))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/file/{id}")
    public FileDto one(@PathVariable Long id){
        File file = fileService.findById(id);
        return fileDtoAssembler.toDto(file);
    }

    @PutMapping(value = "/file/{id}")
    public FileDto update(@PathVariable Long id, @RequestParam("file") MultipartFile multipartFile){
        File file = fileService.findById(id);
        return fileDtoAssembler.toDto(fileService.updateFile(file, multipartFile));
    }

    @DeleteMapping(value = "file/{id}")
    public FileDto delete(@PathVariable Long id){
        File file = fileService.findById(id);
        fileService.delete(file);
        return fileDtoAssembler.toDto(file);
    }
}
