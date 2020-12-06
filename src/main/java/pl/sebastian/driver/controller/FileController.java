package pl.sebastian.driver.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.sebastian.driver.DTO.FileDto;
import pl.sebastian.driver.assembler.FileDtoAssembler;
import pl.sebastian.driver.domain.File;
import pl.sebastian.driver.service.FileService;

@RestController
public class FileController {

    private final FileService fileService;
    private final FileDtoAssembler fileDtoAssembler;

    public FileController(FileService fileService, FileDtoAssembler fileDtoAssembler) {
        this.fileService = fileService;
        this.fileDtoAssembler = fileDtoAssembler;
    }

    @PostMapping(value = "/file")
    public FileDto create(@RequestParam("file") MultipartFile multipartFile) {
        return fileDtoAssembler.toDto(fileService.storeFile(multipartFile));
    }

    @GetMapping(value = "/file/{id}")
    public ResponseEntity<Resource> one(@PathVariable String id) {
        File file = fileService.findById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(new ByteArrayResource(file.getData()));

    }

}
