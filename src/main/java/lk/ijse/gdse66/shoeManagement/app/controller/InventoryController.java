package lk.ijse.gdse66.shoeManagement.app.controller;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.CustomerDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.InventoryDTO;
import lk.ijse.gdse66.shoeManagement.app.repository.InventoryRepo;
import lk.ijse.gdse66.shoeManagement.app.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = "*")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    public InventoryController() {
        System.out.println("Inventory Working");
    }

    @GetMapping("/getAllInventory")
    List<InventoryDTO> getAllInventory() {
        System.out.println("request received");
        return inventoryService.getAllInventory();
    }

    @PostMapping("/save")
    public InventoryDTO saveInventory(@RequestBody InventoryDTO inventoryDTO) {
        System.out.println(inventoryDTO);
        return inventoryService.saveInventory(inventoryDTO);
    }


    @PatchMapping("/update")
    public InventoryDTO updateInventory(@RequestBody InventoryDTO inventoryDTO) {
        System.out.println(inventoryDTO);
        return inventoryService.updateInventory(inventoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable(value = "id") String id){
        inventoryService.deleteInventory(id);
    }

    @GetMapping("/search/{id}")
    public List<InventoryDTO> searchInventory(@PathVariable(value = "id") String id){
        return inventoryService.searchInventory(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/itemIdGenerate")
    public @ResponseBody
    CustomDTO inventoryIdGenerate() {
        return inventoryService.inventoryIdGenerate();
    }
}