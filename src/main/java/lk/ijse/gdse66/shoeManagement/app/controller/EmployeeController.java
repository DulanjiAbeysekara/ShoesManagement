package lk.ijse.gdse66.shoeManagement.app.controller;

import lk.ijse.gdse66.shoeManagement.app.dto.EmployeeDTO;
import lk.ijse.gdse66.shoeManagement.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//package lk.ijse.gdse66.shoeManagement.app.controller;
//
//import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
//import lk.ijse.gdse66.shoeManagement.app.dto.EmployeeDTO;
//import lk.ijse.gdse66.shoeManagement.app.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService1) {
        System.out.println("Employee Service Working");
//        this.employeeService = employeeService;
    }

    @GetMapping("/getAllEmployee")
    List<EmployeeDTO> getAllEmployee() {
        System.out.println("request received");
        return employeeService.getAllEmployee();
    }

    @PostMapping("/save")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        System.out.println(employeeDTO);
        return employeeService.saveEmployee(employeeDTO);
    }

    @PatchMapping("/update")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        System.out.println(employeeDTO);
        return employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable(value = "id") String id) {

        employeeService.deleteEmployee(id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDTO getEmployeeDetails(@PathVariable("id") String id) {
        return employeeService.getEmployeeDetails(id);
    }
}
//}
//@RestController
//@RequestMapping("/employee")
//@CrossOrigin(origins = "*")
//public class EmployeeController{
//
//    @Autowired
//    private EmployeeService employeeService;
//
//        public EmployeeController() {
//            System.out.println("employee working !");
//        }
//
//        @GetMapping("/getAllEmployees")
//        public List<EmployeeDTO> getAllEmployee(){
//            return employeeService.getAllEmployee();
//        }
//
//        @PostMapping("/save")
//        public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO){
//            System.out.println(employeeDTO);
////        customerDTO.setCode(customerService.generateNextId());
//            return employeeService.saveEmployee(employeeDTO);
//        }
//
//        @PostMapping("/update")
//        public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO){
//            System.out.println(employeeDTO);
//            return employeeService.updateEmployee(employeeDTO);
//        }
////
////        @GetMapping("/nextId")
////        public String nextId(){
////            return employeeService.generateNextId();
////        }
//
////        @GetMapping("/search")
////        public List<EmployeeDTO> search(@RequestParam("employeeName") String employeeName){
////            return employeeService.searchEmployee(employeeName);
////        }
//
//        @DeleteMapping("/delete/{employeeCode}")
//        public void delete(@PathVariable("employeeCode") String employeeCode){
//            employeeService.deleteEmployee(employeeCode);
//        }


//
//}