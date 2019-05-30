package vn.edu.leading.shop.services;

import vn.edu.leading.shop.models.OrderDetailModel;

import java.util.List;

public interface OrderDetailService {

    List<OrderDetailModel> findAll();

    List<OrderDetailModel> search(Long id);

    OrderDetailModel findById(Long id);

    boolean update(OrderDetailModel orderDetail);

    void save(OrderDetailModel orderDetail);

    boolean delete(Long id);
}
