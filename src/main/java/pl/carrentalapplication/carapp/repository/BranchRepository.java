package pl.carrentalapplication.carapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carrentalapplication.carapp.model.Branch;




@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {

    Branch findFirstByCity(String city);
    boolean findByCity(String city);
    Branch findAllByCity(String city);
    Branch existsBranchByCity(String city);


}
