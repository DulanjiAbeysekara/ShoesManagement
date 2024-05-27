package lk.ijse.gdse66.shoeManagement.app.controller;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.EmployeeDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.SupplierDTO;
import lk.ijse.gdse66.shoeManagement.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController() {
//        this.customerService = customerService;
        System.out.println("Employee Working");
    }

    @GetMapping("/getAllEmployee")
    List<EmployeeDTO> getAllEmployee(){
        System.out.println("request received");
        return employeeService.getAllEmployee();
    }

    @PostMapping("/save")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        System.out.println(employeeDTO);
        return employeeService.saveEmployee(employeeDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable(value = "id") String id){

        employeeService.deleteEmployee(id);
    }


    @PatchMapping ("/update")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        System.out.println(employeeDTO);
        return employeeService.updateEmployee(employeeDTO);
    }


    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDTO getEmployeeDetails(@PathVariable("id")String id){
        return employeeService.getEmployeeDetails(id);
    }

    @GetMapping("/search/{id}")
    public List<EmployeeDTO> searchEmployee(@PathVariable(value = "id") String id){
        return employeeService.searchEmployee(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/employeeGenerate")
    public @ResponseBody
    CustomDTO employeeIdGenerate() {
        return employeeService.employeeIdGenerate();
    }

}