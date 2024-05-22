package lk.ijse.gdse66.shoeManagement.app.service.impl;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.InventoryDTO;
import lk.ijse.gdse66.shoeManagement.app.entity.InventoryEntity;
import lk.ijse.gdse66.shoeManagement.app.repository.InventoryRepo;
import lk.ijse.gdse66.shoeManagement.app.service.InventoryService;
import lk.ijse.gdse66.shoeManagement.app.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.shoeManagement.app.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;
    @Autowired
    private ModelMapper mapper;

    public InventoryServiceImpl(InventoryRepo inventoryRepo, ModelMapper mapper) {
        this.inventoryRepo = inventoryRepo;
        this.mapper = mapper;
    }

    @Override
    public List<InventoryDTO> getAllInventory() {
        return inventoryRepo.findAll().stream().map(
                inventory -> mapper.map(inventory, InventoryDTO.class)).toList();
    }

    @Override
    public InventoryDTO getInventoryDetails(String id) {
        return null;
    }

    @Override
    public InventoryDTO saveInventory(InventoryDTO inventoryDTO) {
        if (inventoryRepo.existsById(inventoryDTO.getItemCode())){
            throw new DuplicateRecordException("Inventory ID is Already Exist");
        }

        System.out.println(inventoryDTO);
        return mapper.map(inventoryRepo.save(mapper.map(inventoryDTO, InventoryEntity.class)),InventoryDTO.class);
    }

    @Override
    public InventoryDTO updateInventory(InventoryDTO inventoryDTO) {
        if (!inventoryRepo.existsById(inventoryDTO.getItemCode())){
            throw new NotFoundException("Can't find inventory id !!");
        }

        InventoryEntity inventoryEntity=inventoryRepo.findById(inventoryDTO.getItemCode()).get();
        System.out.println("inventory is "+inventoryEntity);

        return mapper.map(inventoryRepo.save(mapper.map(inventoryDTO,InventoryEntity.class)),InventoryDTO.class);
    }

    @Override
    public boolean deleteInventory(String id) {
        if (!inventoryRepo.existsById(id)){
            throw new NotFoundException("Can't find inventory id!!!");
        }
        inventoryRepo.deleteById(id);
        return true;
    }

    @Override
    public CustomDTO inventoryIdGenerate() {
        return new CustomDTO(inventoryRepo.getLastIndex());

    }
}
