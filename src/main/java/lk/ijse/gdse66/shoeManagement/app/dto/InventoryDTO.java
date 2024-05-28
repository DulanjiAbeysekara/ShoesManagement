package lk.ijse.gdse66.shoeManagement.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryDTO implements Serializable {
    private String itemCode;
    private String itemDesc;
    private String itemPicture;
    private String category;

    private Integer size6;
    private Integer size8;
    private Integer size10;
    private Integer size11;
    private String status;
    private String supplierCode;
    private String supplierName;
    private Double unitPriceSale;
    private Double unitPriceBuy;
    private Double expectedProfit;
    private Double profitMargin;

}
