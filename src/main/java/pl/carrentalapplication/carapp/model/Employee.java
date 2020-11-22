package pl.carrentalapplication.carapp.model;

import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String name;

    private String lastName;

    private Position position;
    @ManyToOne
    @JoinColumn(name = "branchId")
    private Branch branch;

    public Employee(String name, String lastName, Position position){
        this.name = name;
        this.lastName = lastName;
        this.position = position;
    }

    public enum Position {

        MANAGER("manager"), EMPLOYEE("employee");

        String position;

        Position(String position) {
            this.position = position;
        }
    }
}

