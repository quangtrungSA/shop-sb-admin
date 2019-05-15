package vn.edu.leading.shop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shop_shippers")
public class ShipperModel extends BaseModel<ShipperModel> {

    @NotEmpty
    @Column(name = "shipper_name", nullable = false)
    private String shipperName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToMany(
            mappedBy = "shipperModel",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 50)
    @JsonBackReference
    private List<OrderModel> orders = new ArrayList<>();
}
