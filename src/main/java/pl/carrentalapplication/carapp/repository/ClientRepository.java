package pl.carrentalapplication.carapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carrentalapplication.carapp.model.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByName(String name);
    Client findFirstByClientId(long clientId);
}
