package com.clauseiq.document.mapper;

import com.clauseiq.document.constant.DocumentStatus;
import com.clauseiq.document.dto.request.CreateDocumentRequest;
import com.clauseiq.document.dto.response.DocumentResponse;
import com.clauseiq.document.entity.Document;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DocumentMapper {

    public Document toEntity(CreateDocumentRequest request) {
        return Document.builder()
                .title(request.getTitle())
                .originalFileName(request.getOriginalFileName())
                .contentType(request.getContentType())
                .fileSize(request.getFileSize())
                .storagePath(request.getStoragePath())
                .status(DocumentStatus.UPLOADED)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public DocumentResponse toResponse(Document document) {
        return DocumentResponse.builder()
                .id(document.getId())
                .title(document.getTitle())
                .originalFileName(document.getOriginalFileName())
                .contentType(document.getContentType())
                .fileSize(document.getFileSize())
                .storagePath(document.getStoragePath())
                .status(document.getStatus())
                .createdAt(document.getCreatedAt())
                .updatedAt(document.getUpdatedAt())
                .build();
    }
}