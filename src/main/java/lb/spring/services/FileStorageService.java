package lb.spring.services;

import java.io.IOException;
import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import lb.spring.entities.FileDB;
import lb.spring.repositories.FileDBRepository;

@Service
public class FileStorageService {
  @Autowired
 FileDBRepository fileDBRepository;

    public FileDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        FileDB fileDb = new FileDB(null,fileName, file.getContentType(), file.getBytes());
        return fileDBRepository.save(fileDb);
    }


}
