package com.rifqimuhammadaziz.springtemplate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDTO {
    private String title;
    private String category;
    private String body;
}
