package lk.ijse.gdse66.shoeManagement.app.service;

import lk.ijse.gdse66.shoeManagement.app.dto.CustomDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.OrderDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.OrderDetailDTO;

import java.util.List;

public interface SaleDetailsService {
    List<OrderDTO> getAllRefundOrders();
    boolean refundOrder(String orderId);

    boolean refundOrderDetails(CustomDTO customDTO);
    OrderDTO getOrderByOrderId(String orderId);
    List<OrderDetailDTO> getOrderDetailListByOrderId(String orderId);
}
