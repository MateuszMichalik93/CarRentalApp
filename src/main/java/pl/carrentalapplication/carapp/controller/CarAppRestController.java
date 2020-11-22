package pl.carrentalapplication.carapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.carrentalapplication.carapp.model.*;
import pl.carrentalapplication.carapp.service.CarAppServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/rest")
public class CarAppRestController {

    private CarAppServiceImpl carAppService;

        @Autowired
    public CarAppRestController(CarAppServiceImpl carAppService) {
        this.carAppService = carAppService;
    }

    @PostMapping("/addCars")
    public boolean addCar(@RequestParam("mark")Car.Mark mark,
                          @RequestParam("model") String model,
                          @RequestParam("carBody")Car.CarBody carBody,
                          @RequestParam("yearbook") int yearbook,
                          @RequestParam("color")Car.Color color,
                          @RequestParam("mileage") int mileage,
                          @RequestParam("status")Car.Status status,
                          @RequestParam("loanAmountPerDay") int loanAmountPerDay,
                          @RequestParam("branchCity") String city) {
        return carAppService.addCar(new Car(mark, model, carBody, yearbook, color, mileage, status, loanAmountPerDay), city);
    }

        @PutMapping("/updateCarsMileage")
        public boolean updateCarMileagebyId(@RequestParam("carId") long carId,
                                            @RequestParam("newMileage") int newMileage){
            return carAppService.updateCarMileagebyId(carId, newMileage);
        }

    @GetMapping("/cars/{mark}")
    public List<Car> getCarByMarkInBranchByBranchId(@RequestParam("branchId") long branchId,
                                                    @RequestParam("mark")Car.Mark mark){
            return carAppService.getCarByMarkInBranchByBranchId(branchId, mark);

    }

    @GetMapping("/findCarByModel")
    public List<Car> getAllCarsByModel(@RequestParam("model") String model,
                                       @RequestParam("branchId") long branchId){
            return carAppService.getCarsByModel(model, branchId);
    }


    @GetMapping("/availableCars")
    public List<Car> getCarsByAvailableInBranch(@RequestParam("branchId") long branchId,
                                                @RequestParam("status") Car.Status status){

        return carAppService.getCarsByAvailableInBranch(branchId, status);
    }

    @DeleteMapping("/deleteCars")
    public boolean deleteCar(@RequestParam("carId") long carId){
         return carAppService.deleteCarById(carId);
    }

    @PostMapping("/addBranches")
    public boolean addBranch(@RequestParam("city") String city,
                            @RequestParam("street") String street,
                            @RequestParam("localNumber") int localNumber,
                            @RequestParam("flatNumber") int flatNumber){
            return carAppService.addBranch(new Branch(city, street, localNumber, flatNumber));
    }

    @PutMapping("/updateBranchesAddress")
    public boolean updateBranchAddressByBranchId(@RequestParam("branchId") long branchId,
                                         @RequestParam("newCity") String newCity,
                                         @RequestParam("newStreet") String newStreet,
                                         @RequestParam("newLocalNumber") int newLocalNumber,
                                         @RequestParam("newFlatNumber") int newFlatNumber){
            return carAppService.updateBranchAddressByBranchId(branchId, newCity, newStreet, newLocalNumber, newFlatNumber);
    }

    @PostMapping("/addEmployees")
    public boolean addEmployee(@RequestParam("name") String name,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("position")Employee.Position position,
                               @RequestParam("branchCity") String city ){
            return carAppService.addEmployee(new Employee(name, lastName, position), city);
    }

   @DeleteMapping("/deleteEmployees")
    public boolean deleteEmployee(@RequestParam("employeeId") long employeeId){
           return carAppService.deleteEmployeeById(employeeId);
   }

   @PostMapping("/addClients")
    public boolean addClient(@RequestParam("name") String name,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("email") String email,
                             @RequestParam("city") String city,
                             @RequestParam("localNumber") int localNumber,
                             @RequestParam("flatNumber") int flatNumber){
            return carAppService.addClient(new Client(name, lastName, email, city, localNumber, flatNumber));
   }

   @PutMapping("/updateClientsAddress")
   public boolean updateClientAddressById(@RequestParam("clientId") long clientId,
                                          @RequestParam("newCity") String newCity,
                                          @RequestParam("newLocalNumber") int newLocalNumber,
                                          @RequestParam("newFlatNumber") int newFlatNumber){
            return carAppService.updateClientAddressById(clientId, newCity, newLocalNumber, newFlatNumber);
   }

   @DeleteMapping("deleteClients")
   public boolean deleteClient(@RequestParam("clientId") long clientId){
            return carAppService.deleteClientById(clientId);
   }

   @PostMapping("/addReservations")
    public boolean addReservation(
                                      @RequestParam("clientId") long clientId,
                                      @RequestParam("carId") long carId,
                                      @RequestParam("rentalCity") String city,
                                      @RequestParam("returnCity") String city2
                                      ){
            return carAppService.addReservation(clientId, carId,
                   city, city2);
   }

   @PutMapping("/updateReservation")
   public boolean updateReservation(@RequestParam("clientId") long clientId,
                                    @RequestParam("newCarId") long carId,
                                    @RequestParam("newRentalCity") String newCity,
                                    @RequestParam("newReturnCity") String newCity2){
            return carAppService.updateReservation(clientId, carId, newCity, newCity2);

   }

   @DeleteMapping("/deleteReservation")
    public boolean deleteReservationById(@RequestParam("reservationId") long reservationId){
            return carAppService.deleteReservationById(reservationId);
    }



}
