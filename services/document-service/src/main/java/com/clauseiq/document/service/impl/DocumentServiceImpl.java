package com.clauseiq.document.service.impl;

import com.clauseiq.document.entity.Document;
import com.clauseiq.document.repository.DocumentRepository;
import com.clauseiq.document.service.DocumentService;
import org.springframework.stereotype.Service;

import java.util.List;
import com.clauseiq.document.exception.DocumentNotFoundException;
import com.clauseiq.document.constant.DocumentStatus;
@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document save(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public Document findById(Long id) {
        return documentRepository.findById(id)
                .orElseThrow(() -> new DocumentNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        Document document = findById(id);

        documentRepository.delete(document);
    }
    @Override
    public Document updateStatus(Long id, DocumentStatus status) {

        Document document = findById(id);

        document.setStatus(status);

        return documentRepository.save(document);
    }

    @Override
    public List<Document> findByStatus(DocumentStatus status) {

        return documentRepository.findByStatus(status);
    }
}