package com.clauseiq.document.service;

import com.clauseiq.document.entity.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentService {

    Document save(Document document);

    List<Document> findAll();

    Optional<Document> findById(Long id);

    void delete(Long id);

}