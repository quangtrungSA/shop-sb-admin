package vn.edu.leading.shop.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shop_order_details")
public class OrderDetailModel extends BaseModel<OrderDetailModel> {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    @BatchSize(size = 50)
    @JsonManagedReference
    private ProductModel productModel;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    @BatchSize(size = 50)
    @JsonManagedReference
    private OrderModel orderModel;

    private Long quantity;
}
