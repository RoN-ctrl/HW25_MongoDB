package com.buzhovych.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Notebook {
    private static long count = 1;

    @Id
    private long id = count++;
    private String model;
    private String producer;
    private String processor;
    private int memoryGb;
    private boolean used;
    private String caseMaterial;
    private double price;
    private String releaseDate;

    public Notebook(String model, String producer, String processor, int memoryGb, boolean used, String caseMaterial,
                    double price, String releaseDate) {
        this.model = model;
        this.producer = producer;
        this.processor = processor;
        this.memoryGb = memoryGb;
        this.used = used;
        this.caseMaterial = caseMaterial;
        this.price = price;
        this.releaseDate = releaseDate;
    }
}
