package com.jdsolutions.uploadservice.service;

import com.jdsolutions.uploadservice.entity.UploadEntity;
import com.jdsolutions.uploadservice.model.UploadRequestTO;
import com.jdsolutions.uploadservice.repository.UploadRespoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@Service
public class UploadService {

    @Autowired
    private UploadRespoitory uploadRespoitory;

    @Value("${jd.media.path.demo}")
    private String demoMediaPath;

    @Value("${jd.media.path.lectures}")
    private String mediaPath;

    public String saveMedia(MultipartFile multipartFile, UploadRequestTO uploadRequestTO) throws IOException {
        byte[] media = multipartFile.getBytes();
        String path = null;
        if (uploadRequestTO.getDemo()) {
            path = demoMediaPath + "/" + multipartFile.getOriginalFilename();
        } else {
            path = mediaPath + "/" + multipartFile.getOriginalFilename();
        }
        Files.write(Path.of(path), media);
        uploadRespoitory.save(UploadEntity.builder()
                                .mediapath(Path.of(path).toString())
                                .topicName(uploadRequestTO.getTopicName())
                                .userName(uploadRequestTO.getUserName())
                            .build());
        return Path.of(path).toString();
    }
}
