package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.OrderDetailModel;
import vn.edu.leading.shop.models.OrderModel;

import java.util.List;


@Service
public class OrderServicelmpl extends BaseService<OrderModel> implements OrderService {

    @Override
    public List<OrderDetailModel> findAllOrderDetailById(Long id) {
        OrderModel orderModel = baseRepository.getOne(id);
        return orderModel.getOrderDetails();
    }
}
