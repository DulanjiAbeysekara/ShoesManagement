package lk.ijse.gdse66.shoeManagement.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Supplier;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
public class InventoryEntity {

    @Id
    @Column(name = "item_code", nullable = false)
    private String itemCode;

    @Column(name = "itemDesc", nullable = false)
    private String itemDesc;

    @Column(name = "itemPicture", columnDefinition = "LONGTEXT")
    private String itemPicture;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "size", nullable = false)
    private Integer size;

    @Column(name = "supplierName", nullable = false)
    private String supplierName;

    @Column(name = "unitPriceSale", nullable = false)
    private Double unitPriceSale;

    @Column(name = "unitPriceBuy", nullable = false)
    private Double unitPriceBuy;

    @Column(name = "expectedProfit", nullable = false)
    private Double expectedProfit;


    @Column(name = "profitMargin", nullable = false)
    private Double profitMargin;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "inventory")
//    private List<SalesDetailsEntity> saleDetails;

}