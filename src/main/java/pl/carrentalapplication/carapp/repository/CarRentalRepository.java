package pl.carrentalapplication.carapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carrentalapplication.carapp.model.CarRental;
@Repository
public interface CarRentalRepository extends JpaRepository<CarRental, Long> {
}
