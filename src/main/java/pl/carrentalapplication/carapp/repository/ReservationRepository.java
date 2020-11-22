package pl.carrentalapplication.carapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carrentalapplication.carapp.model.Reservation;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
