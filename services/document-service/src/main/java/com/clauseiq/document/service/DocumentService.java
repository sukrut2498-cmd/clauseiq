package com.clauseiq.document.service;

import com.clauseiq.document.entity.Document;

import java.util.List;
import com.clauseiq.document.constant.DocumentStatus;

public interface DocumentService {

    Document save(Document document);

    List<Document> findAll();

    Document findById(Long id);

    void delete(Long id);

    Document updateStatus(Long id, DocumentStatus status);

    List<Document> findByStatus(DocumentStatus status);
}