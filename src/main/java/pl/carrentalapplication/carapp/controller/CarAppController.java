package pl.carrentalapplication.carapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.carrentalapplication.carapp.model.Car;
import pl.carrentalapplication.carapp.service.CarAppServiceImpl;

import java.util.List;


@Controller
public class CarAppController {

    private CarAppServiceImpl carAppService;

    @Autowired
    public CarAppController(CarAppServiceImpl carAppService) {
        this.carAppService = carAppService;
    }

    @GetMapping("/")
    public String home() {
        return "shop";
    }
    @GetMapping("/branches")
    public String branches(Model model) {
        model.addAttribute("branches", carAppService.getAllBranches());
        return "branches";
    }
    @PostMapping("/addCars")
    public String addCar(Model model){
    model.addAttribute("car", new Car());
    return "/";
    }

    @GetMapping("/branches&{city}")
    public String branch(@PathVariable("city") String city, Model model){
        model.addAttribute("branch", carAppService.getBranch(city));
        return "branch";
    }

    @GetMapping("/branch@{cars}")
    public String carsInBranch(@PathVariable("cars") List<Car> cars, Model model){
        model.addAttribute("cars", carAppService.getAllCars());
        return "cars";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

}
