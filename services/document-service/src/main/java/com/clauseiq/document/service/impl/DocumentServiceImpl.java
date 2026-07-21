package com.clauseiq.document.service.impl;

import com.clauseiq.document.entity.Document;
import com.clauseiq.document.repository.DocumentRepository;
import com.clauseiq.document.service.DocumentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Document> findById(Long id) {
        return documentRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        documentRepository.deleteById(id);
    }
}