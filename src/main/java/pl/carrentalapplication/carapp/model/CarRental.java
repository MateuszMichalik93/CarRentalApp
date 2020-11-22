package pl.carrentalapplication.carapp.model;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CarRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carRentalId;

    private String name;

    private String domena;

    private String phoneNumber;

    private String OwnerName;

}