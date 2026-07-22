package com.clauseiq.document.controller;

import com.clauseiq.document.dto.request.CreateDocumentRequest;
import com.clauseiq.document.dto.response.DocumentResponse;
import com.clauseiq.document.entity.Document;
import com.clauseiq.document.mapper.DocumentMapper;
import com.clauseiq.document.service.DocumentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;
    private final DocumentMapper documentMapper;

    public DocumentController(DocumentService documentService,
                              DocumentMapper documentMapper) {
        this.documentService = documentService;
        this.documentMapper = documentMapper;
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
}