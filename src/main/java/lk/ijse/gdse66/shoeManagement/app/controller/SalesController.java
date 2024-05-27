//package lk.ijse.gdse66.shoeManagement.app.controller;
//
//import jakarta.validation.Valid;
//import lk.ijse.gdse66.shoeManagement.app.dto.SalesDTO;
//import lk.ijse.gdse66.shoeManagement.app.service.SalesService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/v0/sales")
//@CrossOrigin(origins = "", allowedHeaders = "", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,RequestMethod.PATCH, RequestMethod.OPTIONS})
//public class SalesController {
//
//    private final SalesService saleService;
//
//    public SalesController(SalesService saleService) {
//        this.saleService = saleService;
//    }
//
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    List<SalesDTO> getAllSales(){
//        return saleService.getAllSales();
//    }
//
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    SalesDTO saveSales(@Valid @RequestBody SalesDTO salesDTO){
//        System.out.println(salesDTO);
//        return saleService.saveSales(salesDTO);
//    }
//
//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    void updateSales(@Valid @RequestBody SalesDTO salesDTO){
//        saleService.updateSales(salesDTO.getOrderNo(),salesDTO);
//    }
//
//    @DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    void deleteSales(@PathVariable("id") String id){
//        saleService.deleteSales(id);
//    }
//
//    @PatchMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    SalesDTO getSales(@PathVariable("id") String id){
//        return saleService.getSaleDetails(id);
//    }
//}