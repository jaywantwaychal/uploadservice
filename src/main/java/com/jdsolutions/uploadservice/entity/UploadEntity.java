package com.jdsolutions.uploadservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String mediapath;
    private String topicName;
    private String userName;
}
