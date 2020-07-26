package pl.sebastian.driver.service;

import org.springframework.stereotype.Service;
import pl.sebastian.driver.repository.FileRepository;

@Service
public class FileService {

    private final FileRepository mediaFileRepository;

    public FileService(FileRepository mediaFileRepository) {
        this.mediaFileRepository = mediaFileRepository;
    }
}
