package com.clauseiq.document.controller;

import com.clauseiq.document.constant.DocumentStatus;
import com.clauseiq.document.dto.request.CreateDocumentRequest;
import com.clauseiq.document.dto.response.DocumentResponse;
import com.clauseiq.document.entity.Document;
import com.clauseiq.document.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public DocumentResponse createDocument(@RequestBody CreateDocumentRequest request) {

        Document document = Document.builder()
                .title(request.getTitle())
                .originalFileName(request.getOriginalFileName())
                .contentType(request.getContentType())
                .fileSize(request.getFileSize())
                .storagePath(request.getStoragePath())
                .status(DocumentStatus.UPLOADED)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Document savedDocument = documentService.save(document);

        return DocumentResponse.builder()
                .id(savedDocument.getId())
                .title(savedDocument.getTitle())
                .originalFileName(savedDocument.getOriginalFileName())
                .contentType(savedDocument.getContentType())
                .fileSize(savedDocument.getFileSize())
                .storagePath(savedDocument.getStoragePath())
                .status(savedDocument.getStatus())
                .createdAt(savedDocument.getCreatedAt())
                .updatedAt(savedDocument.getUpdatedAt())
                .build();
    }
}