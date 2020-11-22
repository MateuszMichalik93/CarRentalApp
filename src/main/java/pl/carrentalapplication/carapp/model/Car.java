package pl.carrentalapplication.carapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carId;

    private Mark mark;

    private String model;

    private CarBody carBody;

    private int yearbook;

    private Color color;

    private int mileage;

    private Status status;

    private int loanAmountPerDay;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "branchId")
    private Branch branch;

    public Car(Mark mark, String model, CarBody carBody, int yearbook, Color color,
               int mileage, Status status, int loanAmountPerDay) {
        this.mark = mark;
        this.model = model;
        this.carBody = carBody;
        this.yearbook = yearbook;
        this.color = color;
        this.mileage = mileage;
        this.status = status;
        this.loanAmountPerDay = loanAmountPerDay;

    }

    public enum Mark{
        BMW("Bmw"), MERCEDES("Mercedes"), AUDI("Audi"), FIAT("Fiat");

        String mark;

        Mark(String mark) {
            this.mark = mark;
        }
    }

    public enum CarBody{
        HATCHBACK("Hatchback"), COMBI("Combi"), SEDAN("Sedan");

        String carBody;

        CarBody(String carBody) {
            this.carBody = carBody;
        }
    }
    public enum Color{
        BLUE("Blue"), BLACK("Black"), WHTIE("White"), RED("Red"), YELLOW("Yellow");

        String color;

        Color(String color) {
            this.color = color;
        }
    }

    public enum Status{
        AVAILABLE("available"), UNAVAILABLE("unavailable");

        String status;

        Status(String status) {
            this.status = status;
        }
    }
}
