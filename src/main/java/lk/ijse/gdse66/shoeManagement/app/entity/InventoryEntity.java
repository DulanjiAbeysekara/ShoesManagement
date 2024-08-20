package lk.ijse.gdse66.shoeManagement.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
public class InventoryEntity {

    @Id
    private String itemCode;

    private String itemDesc;

//    @Column(columnDefinition = "LONGTEXT")
    private String itemPicture;

    private String category;

    private Integer size6;
    private Integer size8;
    private Integer size10;
    private Integer size11;
    private String supplierCode;
    private String supplierName;
    private String status;
    private Double unitPriceSale;

    private Double unitPriceBuy;

    private Double expectedProfit;

    private Double profitMargin;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item_code")
    private List<SalesDetailEntity> orderDetails = new ArrayList<>();

}