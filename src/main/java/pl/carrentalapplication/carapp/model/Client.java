package pl.carrentalapplication.carapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;
    private String name;
    private String lastName;
    private String email;
    private String city;
    private int localNumber;
    private int flatNumber;
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservationset;

    public Client(String name, String lastName, String email, String city, int localNumber, int flatNumber){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.localNumber = localNumber;
        this.flatNumber = flatNumber;
    }


}
