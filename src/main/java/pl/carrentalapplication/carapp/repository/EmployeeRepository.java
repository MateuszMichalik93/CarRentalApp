package pl.carrentalapplication.carapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carrentalapplication.carapp.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
