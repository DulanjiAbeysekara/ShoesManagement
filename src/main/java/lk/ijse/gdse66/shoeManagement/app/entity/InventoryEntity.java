package lk.ijse.gdse66.shoeManagement.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class InventoryEntity {
        @Id
    private String itemCode;

    private String itemDesc;
    private String itemPicture;
    private String category;
    private int size;
    private String supplierCode;
    private String supplierName;
    private Double unitpricesale;
    private Double unitPriceBuy;
    private Double expectedProfit;
    private Double profitMargin;
    private String status;
}
