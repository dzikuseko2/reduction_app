package com.dzikuseko2.reduction_app;

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
    private float bodyw;

    private String description;

    public Weight() {
    }

    public Weight(int id, LocalDate dateWeight, float bodyw, String description) {
        this.id = id;
        this.dateWeight = dateWeight;
        this.bodyw = bodyw;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateWeight() {
        return dateWeight;
    }

    public void setDateWeight(LocalDate dateWeight) {
        this.dateWeight = dateWeight;
    }

    public float getBodyw() {
        return bodyw;
    }

    public void setBodyw(float bodyw) {
        this.bodyw = bodyw;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "id=" + id +
                ", dateWeight=" + dateWeight +
                ", bodyw=" + bodyw +
                ", description='" + description + '\'' +
                '}';
    }

    public void updatedFrom(Weight toUpdate){
        dateWeight = toUpdate.dateWeight;
        bodyw =toUpdate.bodyw;
        description = toUpdate.description;
    }
}