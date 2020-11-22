package pl.carrentalapplication.carapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.carrentalapplication.carapp.model.*;
import pl.carrentalapplication.carapp.repository.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static pl.carrentalapplication.carapp.model.Car.Status.AVAILABLE;


@Service
public class CarAppServiceImpl implements CarAppService {

    private EmployeeRepository employeeRepository;
    private CarRepository carRepository;
    private BranchRepository branchRepository;
    private ReservationRepository reservationRepository;
    private ClientRepository clientRepository;

    @Autowired
    public CarAppServiceImpl(EmployeeRepository employeeRepository, CarRepository carRepository,
                             BranchRepository branchRepository, ReservationRepository reservationRepository,
                             ClientRepository clientRepository) {
        this.employeeRepository = employeeRepository;
        this.carRepository = carRepository;
        this.branchRepository = branchRepository;
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public boolean addCar(Car car, String city) {
            Branch branch =  branchRepository.findFirstByCity(city);
            car.setBranch(branch);
            carRepository.save(car);
            return true;
    }

    @Override
    public boolean updateCarMileagebyId(long carId, int newMileage) {
        if(carRepository.findById(carId).isPresent()){
           Car carMileageToUpdate = carRepository.findById(carId).get();
           carMileageToUpdate.setMileage(newMileage);
           carRepository.save(carMileageToUpdate);
           return true;
        }
        return false;
    }

    @Override
    public List<Car> getCarByMarkInBranchByBranchId(long branchId, Car.Mark mark) {
               if(branchRepository.existsById(branchId)) {
                   Branch branch = branchRepository.findById(branchId).get();
                   return branch.getAvailableCars().stream().filter(Car-> Car.getMark() == mark).collect(Collectors.toList());
               }
            return new ArrayList<>();
        }



    @Override
    public List<Car> getCarsByModel(String model, long branchId) {
        if(branchRepository.existsById(branchId)) {
            Branch branch = branchRepository.findById(branchId).get();
            return branch.getAvailableCars().stream().filter(Car-> Car.getModel() == model).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }


    @Override
    public boolean deleteCarById(long carId) {
        boolean isDeleted = carRepository.existsById(carId);
        carRepository.deleteById(carId);
        return isDeleted;
    }


    @Override
    public List<Car> getCarsByAvailableInBranch(long branchId, Car.Status status) {
           if(branchRepository.existsById(branchId)) {
               Branch branch = branchRepository.findById(branchId).get();
               return branch.getAvailableCars().stream().filter(car -> car.getStatus() == AVAILABLE).collect(Collectors.toList());
           }
           return new ArrayList<>();
    }


    @Override
    public boolean addBranch(Branch branch) {
        if(branchRepository.findFirstByCity(branch.getCity()) == null){
            branchRepository.save(branch);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Branch> getBranchById(long branchId) {
        return branchRepository.findById(branchId);
    }

    @Override
    public boolean updateBranchAddressByBranchId(long branchId, String newCity, String newStreet,
                                                 int newFlatNumber, int newLocalNumber) {
       if(branchRepository.existsById(branchId)) {
           Branch branchToUpdateAddress = branchRepository.findById(branchId).get();
           branchToUpdateAddress.setCity(newCity);
           branchToUpdateAddress.setStreet(newStreet);
           branchToUpdateAddress.setFlatNumber(newFlatNumber);
           branchToUpdateAddress.setLocalNumber(newLocalNumber);
           branchRepository.save(branchToUpdateAddress);
           return true;
       }
        return false;
    }


    @Override
    public boolean addEmployee(Employee employee,String  city) {
            Branch branch = branchRepository.findFirstByCity(city);
            employee.setBranch(branch);
            employeeRepository.save(employee);
            return true;
    }

    @Override
    public boolean deleteEmployeeById(long employeeId) {
            boolean isDeleted = employeeRepository.existsById(employeeId);
                employeeRepository.deleteById(employeeId);
        return isDeleted;
    }

    @Override
    public boolean addClient(Client client) {
        clientRepository.save(client);
        return true;
    }

    @Override
    public boolean deleteClientById(long clientId) {
        boolean isDelete = clientRepository.existsById(clientId);
        clientRepository.deleteById(clientId);
        return isDelete;
    }

    @Override
    public boolean updateClientAddressById(long clientId, String newCity, int newLocalNumber, int newFlatNumber) {
        if(clientRepository.findById(clientId).isPresent()){
            Client clientAddressToUpdate = clientRepository.findById(clientId).get();
            clientAddressToUpdate.setCity(newCity);
            clientAddressToUpdate.setLocalNumber(newLocalNumber);
            clientAddressToUpdate.setFlatNumber(newFlatNumber);
            clientRepository.save(clientAddressToUpdate);
            return true;
        }
        return false;
    }


    @Override
    public boolean addReservation(long clientId, long carId,
                                      String city, String city2) {
        LocalDateTime reservationDate = LocalDateTime.now();
        Client client = clientRepository.findFirstByClientId(clientId);
       Car car = carRepository.findFirstByCarId(carId);
     Branch rentalBranch = branchRepository.findFirstByCity(city);
        Branch returnBranch = branchRepository.findFirstByCity(city2);
        reservationRepository.save(new Reservation(reservationDate,client,car, rentalBranch,returnBranch));
        return true;
    }

    @Override
    public boolean updateReservation(long clientId, long newCarId, String newCity, String newCity2) {
        LocalDateTime updateReservationDate = LocalDateTime.now();
        Client client = clientRepository.findFirstByClientId(clientId);
        Car car = carRepository.findFirstByCarId(newCarId);
        Branch rentalBranch = branchRepository.findFirstByCity(newCity);
        Branch returnBranch = branchRepository.findFirstByCity(newCity2);
        reservationRepository.save(new Reservation(updateReservationDate,client, car, rentalBranch, returnBranch));
        return false;
    }

    @Override
    public boolean deleteReservationById(long reservationId){
        boolean isDelete = reservationRepository.existsById(reservationId);
        reservationRepository.deleteById(reservationId);
        return isDelete;
    }

    @Override
    public List<Branch> getAllBranches() {
      List<Branch> branches = branchRepository.findAll();
        return branches;
    }

    @Override
    public Branch getBranch(String city) {
        Branch branch = branchRepository.findFirstByCity(city);
        return branch;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }


}
