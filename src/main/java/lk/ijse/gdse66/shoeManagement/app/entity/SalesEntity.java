//package lk.ijse.gdse66.shoeManagement.app.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "sales")
//public class SalesEntity {
//
//    @Id
//    @Column(name = "order_no")
//    private String orderNo;
//
//    private String customerName;
//
//    private Double totalPrice;
//
//    private Date purchaseDate;
//
//    private String paymentMethod;
//
//    private Double addedPoints;
//
//    private String cashierName;
//
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sales")
//    private List<SalesDetailsEntity> salesDetails = new ArrayList<>();
//}