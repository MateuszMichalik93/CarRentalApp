package pl.carrentalapplication.carapp.service;

import pl.carrentalapplication.carapp.model.*;


import java.util.List;
import java.util.Optional;


public interface CarAppService {


    boolean addCar(Car car, String city);

    boolean updateCarMileagebyId(long carId, int Mileage);

    List<Car> getCarByMarkInBranchByBranchId(long branchId, Car.Mark mark);

    List<Car> getCarsByModel(String model, long branchId);

    boolean deleteCarById(long carId);

    List<Car> getCarsByAvailableInBranch(long branchId, Car.Status status);



    boolean addBranch(Branch branch);

    Optional<Branch> getBranchById(long branchId);

    boolean updateBranchAddressByBranchId(long branchId, String newCity, String newStreet, int newFlatNumber, int newLocalNumber);

    boolean addEmployee(Employee employee, String city );

  boolean deleteEmployeeById(long employeeId);

  boolean addClient(Client client);

  boolean deleteClientById(long clientId);

  boolean updateClientAddressById(long clientId, String newCity, int newLocalNumber, int newFlatNumber);

  boolean addReservation(long clientId, long carId,
                         String city, String city2);

  boolean updateReservation(long clientId, long newCarId, String newCity, String newCity2);

  boolean deleteReservationById(long reservationId);


   List<Branch> getAllBranches();

    Branch getBranch(String city);

    List<Car> getAllCars();
}