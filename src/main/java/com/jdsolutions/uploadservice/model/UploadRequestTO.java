package com.jdsolutions.uploadservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UploadRequestTO {

    private String topicName;
    private String userName;
    private Boolean demo;
}
