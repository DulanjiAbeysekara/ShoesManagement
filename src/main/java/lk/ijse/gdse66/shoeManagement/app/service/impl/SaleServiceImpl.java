package lk.ijse.gdse66.shoeManagement.app.service.impl;

import lk.ijse.gdse66.shoeManagement.app.dto.OrderDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.OrderDetailDTO;
import lk.ijse.gdse66.shoeManagement.app.entity.CustomerEntity;
import lk.ijse.gdse66.shoeManagement.app.entity.SalesDetailEntity;
import lk.ijse.gdse66.shoeManagement.app.entity.SalesEntity;
import lk.ijse.gdse66.shoeManagement.app.entity.SalesPkEntity;
import lk.ijse.gdse66.shoeManagement.app.repository.CustomerRepo;
import lk.ijse.gdse66.shoeManagement.app.repository.InventoryRepo;
import lk.ijse.gdse66.shoeManagement.app.repository.SaleDetailsRepo;
import lk.ijse.gdse66.shoeManagement.app.repository.SaleRepo;
import lk.ijse.gdse66.shoeManagement.app.service.SaleService;
import lk.ijse.gdse66.shoeManagement.app.util.Level;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleDetailsRepo orderDetailRepo;
    @Autowired
    private SaleRepo orderRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private InventoryRepo inventoryRepo;
    @Autowired
    private ModelMapper mapper;


    @Override
    public void placeOrder(OrderDTO orderDTO) {
        SalesEntity order = mapper.map(orderDTO, SalesEntity.class);


        CustomerEntity customer = customerRepo.findByCustomerCode(orderDTO.getCustomer_id());
        order.setCustomer_id(customer);

        int currentPoints = customer.getTotalPoints();
        int addedPoints = orderDTO.getAddedPoints();

        int newPoints = currentPoints+addedPoints;
        Level loyaltyLevel = null;
        if (newPoints < 10){
            loyaltyLevel = Level.NEW;
        }else if (newPoints >= 10 && newPoints<30){
            loyaltyLevel = Level.BRONZE;
        } else if (newPoints >= 30 && newPoints<100) {
            loyaltyLevel = Level.SILVER;
        } else if (newPoints >= 100) {
            loyaltyLevel = Level.GOLD;
        }
        customer.setLevel(loyaltyLevel);
        customer.setTotalPoints(newPoints);

        System.out.println("order Date  ="+ orderDTO.getOrderDate());
        customer.setJoinDateLoyaltyCustomer(orderDTO.getOrderDate());
        customerRepo.save(customer);

//        /update item and save order-details /////////////////////////////////

        System.out.println("qqqqqqqqqqqqqqqqqq"+ order);
        orderRepo.save(order);
        System.out.println("12345"+orderDTO.getOrderDetailDTOList());
        for (OrderDetailDTO detailDTO : orderDTO.getOrderDetailDTOList()) {
            SalesPkEntity orderDetailPK = new SalesPkEntity(detailDTO.getOrder_id(),detailDTO.getItem_code(),detailDTO.getSize());

            SalesDetailEntity orderDetail = new SalesDetailEntity();

            orderDetail.setOrderDetailPK(orderDetailPK);
            orderDetail.setItemName(detailDTO.getItemName());
            orderDetail.setUnitPrice(detailDTO.getUnitPrice());
            orderDetail.setItemQty(detailDTO.getItemQty());



            orderDetailRepo.save(orderDetail);

//            /update item /////////////////////////////////
            int availableQty = inventoryRepo.findQtyByItemCodeAndSize(detailDTO.getItem_code(), detailDTO.getSize());
            int newQty = availableQty - detailDTO.getItemQty();

            String status;
            if (newQty<=0){
                status="Not Available";
            } else if (newQty<10) {
                status="Low";
            } else {
                status="Available";
            }
            inventoryRepo.updateByItemCodeAndSize(newQty, status, detailDTO.getItem_code(),detailDTO.getSize());
        }


    }
}
