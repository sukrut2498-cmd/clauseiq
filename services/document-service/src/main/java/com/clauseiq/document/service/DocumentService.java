package com.clauseiq.document.service;

import com.clauseiq.document.entity.Document;

import java.util.List;


public interface DocumentService {

    Document save(Document document);

    List<Document> findAll();

    Document findById(Long id);

    void delete(Long id);


}