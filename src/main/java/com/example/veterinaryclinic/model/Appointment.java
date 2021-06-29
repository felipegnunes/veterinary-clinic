package com.example.veterinaryclinic.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal price;
    private Timestamp appointmentTime;
    private boolean isPaid = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "animal_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Animal animal;

    public Appointment() {
    }

    public Appointment(BigDecimal price, Timestamp appointmentTime, Animal animal) {
        this.price = price;
        this.appointmentTime = appointmentTime;
        this.animal = animal;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public Timestamp getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Timestamp appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String toString() {
        return String.format("<Appointment at %s>", appointmentTime);
    }
}
