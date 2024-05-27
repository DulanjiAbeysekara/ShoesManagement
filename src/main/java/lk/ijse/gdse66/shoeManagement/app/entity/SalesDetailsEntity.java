//package lk.ijse.gdse66.shoeManagement.app.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "Sales_Details")
//public class SalesDetailsEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int salesId;
//
//    private String itemDescription;
//
//    private Integer size;
//
//    private Double unitPriceSale;
//
//    private int quantity;
//
//    @ManyToOne
//    @JoinColumn(name = "item_code" , referencedColumnName = "item_code")
//    private InventoryEntity inventory;
//
//    @ManyToOne
//    @JoinColumn(name = "order_no" , referencedColumnName = "order_no")
//    private SalesEntity sales;
//
//}