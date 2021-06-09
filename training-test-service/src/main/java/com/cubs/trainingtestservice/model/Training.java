package com.cubs.trainingtestservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "training")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Training {
    @Id
    private Long id;
    //private Date date;
    private String lieu;
    private String description;
    private String type;
}