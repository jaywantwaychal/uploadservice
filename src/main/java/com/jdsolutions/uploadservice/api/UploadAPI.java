package com.jdsolutions.uploadservice.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdsolutions.uploadservice.model.UploadRequestTO;
import com.jdsolutions.uploadservice.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/api/upload")
public class UploadAPI {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/lectures/{topic}")
    public ResponseEntity<String> uploadMedia(@RequestParam MultipartFile media, @PathVariable("topic") String topic) throws IOException {
        //getuser from JWT
        //and set in UploadRequestTO
        //also set isDemo false
        return ResponseEntity.ok()
                .header("Authorization", "value")
                .body(uploadService.saveMedia(media, UploadRequestTO.builder().topicName(topic).userName("USER").build()));
    }

    @PostMapping("/demo/lectures")
    public ResponseEntity<String> uploadDemoMedia(@RequestParam MultipartFile media, @PathVariable("topic") String topic) throws IOException {
        //getuser from JWT
        //and set in UploadRequestTO
        //also set isDemo true
        return ResponseEntity.ok()
                .header("Authorization", "value")
                .body(uploadService.saveMedia(media, UploadRequestTO.builder().topicName(topic).userName("USER").build()));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> upload(@RequestPart("upload") String upload, @RequestPart("media") MultipartFile media) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return ResponseEntity.ok()
                .header("Authorization", "uplaoded")
                .body(uploadService.saveMedia(media, mapper.readValue(upload, UploadRequestTO.class)));
    }
}
