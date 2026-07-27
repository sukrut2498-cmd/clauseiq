package com.clauseiq.document.controller;

import com.clauseiq.document.constant.DocumentStatus;
import com.clauseiq.document.dto.request.CreateDocumentRequest;
import com.clauseiq.document.dto.response.DocumentResponse;
import com.clauseiq.document.entity.Document;
import com.clauseiq.document.mapper.DocumentMapper;
import com.clauseiq.document.service.DocumentService;
import com.clauseiq.document.service.FileStorageService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;
    private final DocumentMapper documentMapper;
    private final FileStorageService fileStorageService;
    public DocumentController(DocumentService documentService,
                              DocumentMapper documentMapper, FileStorageService fileStorageService) {
        this.documentService = documentService;
        this.documentMapper = documentMapper;
        this.fileStorageService = fileStorageService;
    }

    @PostMapping
    public DocumentResponse createDocument(@Valid @RequestBody CreateDocumentRequest request) {

        Document document = documentMapper.toEntity(request);

        Document savedDocument = documentService.save(document);

        return documentMapper.toResponse(savedDocument);
    }

    @GetMapping
    public List<DocumentResponse> getAllDocuments() {

        return documentService.findAll()
                .stream()
                .map(documentMapper::toResponse)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public DocumentResponse getDocumentById(@PathVariable Long id) {

        Document document = documentService.findById(id);

        return documentMapper.toResponse(document);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDocument(@PathVariable Long id) {

        documentService.delete(id);

    }
    @PostMapping("/upload")
    public DocumentResponse uploadFile(@RequestParam("file") MultipartFile file) {

        String storagePath = fileStorageService.storeFile(file);

        Document document = new Document();

        document.setTitle(file.getOriginalFilename());
        document.setOriginalFileName(file.getOriginalFilename());
        document.setStoragePath(storagePath);
        document.setContentType(file.getContentType());
        document.setFileSize(file.getSize());
        document.setStatus(DocumentStatus.UPLOADED);

        Document savedDocument = documentService.save(document);

        return documentMapper.toResponse(savedDocument);
    }

}