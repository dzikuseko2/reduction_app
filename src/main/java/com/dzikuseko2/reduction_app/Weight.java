package com.dzikuseko2.reduction_app;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "weights")
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="date_weight")
    private LocalDate dateWeight;

    @Column(name="body_weight")
    private float bodyWeight;

    private String description;

    public Weight() {
    }

    public Weight(int id, LocalDate dateWeight, float bodyWeight, String description) {
        this.id = id;
        this.dateWeight = dateWeight;
        this.bodyWeight = bodyWeight;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return dateWeight;
    }

    public void setDate (LocalDate dateWeight) {
        this.dateWeight = dateWeight;
    }
    public float getBodyWeight() {
        return bodyWeight;
    }

    public void setWeight(float bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void updatedFrom(Weight toUpdate){
        dateWeight = toUpdate.dateWeight;
        bodyWeight=toUpdate.bodyWeight;
        description = toUpdate.description;
    }
}