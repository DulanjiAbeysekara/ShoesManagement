package lk.ijse.gdse66.shoeManagement.app.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse66.shoeManagement.app.dto.CustomDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.OrderDTO;
import lk.ijse.gdse66.shoeManagement.app.dto.OrderDetailDTO;
import lk.ijse.gdse66.shoeManagement.app.service.SaleDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SalesDetailsServiceImpl implements SaleDetailsService {
    @Override
    public List<OrderDTO> getAllRefundOrders() {
        return null;
    }

    @Override
    public boolean refundOrder(String orderId) {
        return false;
    }

    @Override
    public boolean refundOrderDetails(CustomDTO customDTO) {
        return false;
    }

    @Override
    public OrderDTO getOrderByOrderId(String orderId) {
        return null;
    }

    @Override
    public List<OrderDetailDTO> getOrderDetailListByOrderId(String orderId) {
        return null;
    }
}
