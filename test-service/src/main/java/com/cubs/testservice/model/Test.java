package com.cubs.testservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "test")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Test {
    @Id
    private Long id;
    private String player;
    private String type;
    private String name;
    private String description;
    private float result;
    private String comment;
}
