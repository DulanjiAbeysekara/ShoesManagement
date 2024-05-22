package lk.ijse.gdse66.shoeManagement.app.service.impl;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.EmployeeDTO;
import lk.ijse.gdse66.shoeManagement.app.entity.CustomerEntity;
import lk.ijse.gdse66.shoeManagement.app.entity.EmployeeEntity;
import lk.ijse.gdse66.shoeManagement.app.repository.CustomerRepo;
import lk.ijse.gdse66.shoeManagement.app.repository.EmployeeRepo;
import lk.ijse.gdse66.shoeManagement.app.service.EmployeeService;
import lk.ijse.gdse66.shoeManagement.app.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.shoeManagement.app.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper mapper;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo, ModelMapper mapper) {
        this.employeeRepo = employeeRepo;
        this.mapper = mapper;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepo.findAll().stream().map(
                employee -> mapper.map(employee, EmployeeDTO.class)).toList();
    }

    @Override
    public EmployeeDTO getEmployeeDetails(String id) {
        return null;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepo.existsById(employeeDTO.getEmployeeCode())) {
            throw new DuplicateRecordException("employee ID is Already Exist");

        }
        System.out.println(employeeDTO);
        return mapper.map(employeeRepo.save(mapper.map(employeeDTO, EmployeeEntity.class)), EmployeeDTO.class);
    }


    @Override
    public EmployeeDTO updateEmployee( EmployeeDTO employeeDTO) {
        if (!employeeRepo.existsById(employeeDTO.getEmployeeCode())){
            throw new NotFoundException("Can't find employee id !!");
        }

        EmployeeEntity employeeEntity = employeeRepo.findById(employeeDTO.getEmployeeCode()).get();
        System.out.println("employee is "+employeeEntity);

        employeeDTO.setAccessRole(employeeEntity.getAccessRole());
        employeeDTO.setDob(employeeEntity.getDob());
        employeeDTO.setDateOfJoin(employeeEntity.getDateOfJoin());

        return mapper.map(employeeRepo.save(mapper.map(employeeDTO, EmployeeEntity.class)), EmployeeDTO.class);

    }


    @Override
    public boolean deleteEmployee(String id) {
        if (!employeeRepo.existsById(id)) {
            throw new NotFoundException("Can't find employee id!!!");
        }
        employeeRepo.deleteById(id);
        return true;
    }

    @Override
    public CustomDTO employeeIdGenerate() {
        return new CustomDTO(employeeRepo.getLastIndex());
    }
}
