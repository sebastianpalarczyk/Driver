package pl.sebastian.driver.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.sebastian.driver.domain.File;
import pl.sebastian.driver.exception.FileStorageException;
import pl.sebastian.driver.repository.FileRepository;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;

    public FileService(FileRepository mediaFileRepository) {
        this.fileRepository = mediaFileRepository;
    }

    public File findById(Long id){
        return fileRepository.findById(id).get();
    }

    public void delete(File file){
        fileRepository.delete(file);
    }

    public List<File> all(){
        return fileRepository.findAll();
    }

    public File storeFile(MultipartFile multipartFile) {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            File file = new File();
            file.setFileName(fileName);
            file.setData(multipartFile.getBytes());
            file.setFileType(multipartFile.getContentType());

            return fileRepository.save(file);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
   }

    public File updateFile(File file, MultipartFile multipartFile) {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            file.setFileName(fileName);
            file.setData(multipartFile.getBytes());
            file.setFileType(multipartFile.getContentType());

            return fileRepository.save(file);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
}
