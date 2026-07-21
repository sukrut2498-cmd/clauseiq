package com.clauseiq.document.dto.response;

import com.clauseiq.document.constant.DocumentStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class DocumentResponse {

    private Long id;

    private String title;

    private String originalFileName;

    private String contentType;

    private Long fileSize;

    private String storagePath;

    private DocumentStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}