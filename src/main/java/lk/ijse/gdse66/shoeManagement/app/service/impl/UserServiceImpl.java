package lk.ijse.gdse66.shoeManagement.app.service.impl;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.UserDTO;
import lk.ijse.gdse66.shoeManagement.app.entity.CustomerEntity;
import lk.ijse.gdse66.shoeManagement.app.entity.UserEntity;
import lk.ijse.gdse66.shoeManagement.app.repository.UserRepo;
import lk.ijse.gdse66.shoeManagement.app.service.UserService;
import lk.ijse.gdse66.shoeManagement.app.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.shoeManagement.app.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepo.findAll().stream().map(
                users -> mapper.map(users, UserDTO.class)).toList();
    }

    @Override
    public UserDTO getUserDetails(String id) {
        return null;
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getUserId())) {
            throw new DuplicateRecordException("customer ID is Already Exist");

        }
        System.out.println(userDTO);
        return mapper.map(userRepo.save(mapper.map(userDTO, UserEntity.class)), UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        if (!userRepo.existsById(userDTO.getUserId())) {
            throw new NotFoundException("Can't find customer id !!");
        }

        UserEntity userEntity = userRepo.findById(userDTO.getUserId()).get();
        System.out.println("user is " + userEntity);

        return mapper.map(userRepo.save(mapper.map(userDTO, UserEntity.class)), UserDTO.class);

    }

    @Override
    public boolean deleteUser(String id) {
        if (!userRepo.existsById(id)) {
            throw new NotFoundException("Can't find user id!!!");
        }
        userRepo.deleteById(id);
        return true;
    }
}