package com.jdsolutions.uploadservice.repository;

import com.jdsolutions.uploadservice.entity.UploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadRespoitory extends JpaRepository<UploadEntity, Long> {
}
