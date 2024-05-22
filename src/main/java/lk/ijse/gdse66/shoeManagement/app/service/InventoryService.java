package lk.ijse.gdse66.shoeManagement.app.service;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    List<InventoryDTO> getAllInventory();

    InventoryDTO getInventoryDetails(String id);

    InventoryDTO saveInventory(InventoryDTO inventoryDTO);

    InventoryDTO updateInventory(InventoryDTO inventoryDTO);

    boolean deleteInventory(String id);



}
