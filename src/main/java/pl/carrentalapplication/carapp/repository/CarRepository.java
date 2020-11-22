package pl.carrentalapplication.carapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carrentalapplication.carapp.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findFirstCarByMark(Car.Mark mark);
    Car findFirstByCarId(long carId);
    Car findAllByModel(String model);
    boolean existsByModel(String model);
}
