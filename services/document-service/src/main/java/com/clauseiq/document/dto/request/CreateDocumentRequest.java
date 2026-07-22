package com.clauseiq.document.dto.request;

import com.clauseiq.document.constant.DocumentStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Getter
@Setter
public class CreateDocumentRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Original file name is required")
    private String originalFileName;

    @NotBlank(message = "Storage path is required")
    private String storagePath;

    @NotBlank(message = "Content type is required")
    private String contentType;

    @Positive(message = "File size must be greater than zero")
    private Long fileSize;

    @NotNull(message = "Status is required")
    private DocumentStatus status;
}