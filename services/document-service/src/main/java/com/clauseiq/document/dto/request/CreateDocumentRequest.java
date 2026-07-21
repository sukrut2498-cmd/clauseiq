package com.clauseiq.document.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDocumentRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Original file name is required")
    private String originalFileName;

    @NotBlank(message = "Content type is required")
    private String contentType;

    private Long fileSize;

    @NotBlank(message = "Storage path is required")
    private String storagePath;
}