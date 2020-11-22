package pl.carrentalapplication.carapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationId;


    private LocalDateTime reservationDate;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;
    @OneToOne
    private Car car;
    @OneToOne
    private Branch rentalBranch;
    @OneToOne
    private Branch returnBranch;

    public Reservation(LocalDateTime reservationDate, Client client, Car car, Branch rentalBranch, Branch returnBranch){
        this.reservationDate = reservationDate;
        this.client = client;
        this.car = car;
        this.rentalBranch = rentalBranch;
        this.returnBranch = returnBranch;
    }




}