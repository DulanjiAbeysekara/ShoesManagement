package lk.ijse.gdse66.shoeManagement.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales_details")
public class SalesDetailEntity  {

    @EmbeddedId
    private SalesPkEntity orderDetailPK;

    private String itemName;
    private Double unitPrice;
    private Integer itemQty;

    @ManyToOne
    @JoinColumn(name = "order_id",
            referencedColumnName = "order_id",insertable = false,
            updatable = false)
    private SalesEntity order_id;

    @ManyToOne
    @JoinColumn(name = "item_code",
            referencedColumnName = "itemCode",
            insertable = false,
            updatable = false)
    private InventoryEntity item_code;
}
