package lk.ijse.gdse66.shoeManagement.app.controller;

import lk.ijse.gdse66.shoeManagement.app.dto.OrderDTO;
import lk.ijse.gdse66.shoeManagement.app.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
@CrossOrigin(origins="*")
public class OrderController {

    @Autowired
    private SaleService salesService;

    public OrderController() {
        System.out.println("Sales Working");
    }

    @PostMapping("/save")
    public void save(@RequestBody OrderDTO orderDTO){
        System.out.println(orderDTO);

        salesService.placeOrder(orderDTO);
    }
}
