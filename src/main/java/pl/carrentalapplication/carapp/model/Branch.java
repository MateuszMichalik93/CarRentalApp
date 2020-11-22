package pl.carrentalapplication.carapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long branchId;
    private String city;
    private String street;
    private int localNumber;
    private int flatNumber;
    @JsonIgnore
    @OneToMany(mappedBy = "branch")
    private List<Car> availableCars = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "branch")
    private List<Employee> employees = new ArrayList<>();

        public Branch(String city, String street, int localNumber, int flatNumber){
            this.city = city;
            this.street = street;
            this.localNumber = localNumber;
            this.flatNumber = flatNumber;
        }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", localNumber=" + localNumber +
                ", flatNumber=" + flatNumber +
                '}';
    }
}