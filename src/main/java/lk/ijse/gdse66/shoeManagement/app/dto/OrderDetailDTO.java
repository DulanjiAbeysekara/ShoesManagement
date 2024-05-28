package lk.ijse.gdse66.shoeManagement.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetailDTO {
    private String order_id;
    private String item_code;
    private String itemName;
    private String size;
    private Double unitPrice;
    private Integer itemQty;
}
