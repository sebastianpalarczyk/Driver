package pl.sebastian.driver.controller;

import org.springframework.stereotype.Controller;
import pl.sebastian.driver.service.FileService;

@Controller
public class FIleController {

    private final FileService fileService;

    public FIleController(FileService fileService) {
        this.fileService = fileService;
    }
}
