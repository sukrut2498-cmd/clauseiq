package com.clauseiq.document.controller;

import com.clauseiq.document.dto.request.CreateDocumentRequest;
import com.clauseiq.document.dto.response.DocumentResponse;
import com.clauseiq.document.entity.Document;
import com.clauseiq.document.mapper.DocumentMapper;
import com.clauseiq.document.service.DocumentService;
import org.springframework.web.bind.annotation.*;

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
    public DocumentResponse createDocument(@RequestBody CreateDocumentRequest request) {

        Document document = documentMapper.toEntity(request);

        Document savedDocument = documentService.save(document);

        return documentMapper.toResponse(savedDocument);
    }
}