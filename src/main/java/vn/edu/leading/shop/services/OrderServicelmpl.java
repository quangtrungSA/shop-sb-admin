package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.OrderModel;
import vn.edu.leading.shop.repositories.OrderRepository;

import java.util.List;

@Service
public class OrderServicelmpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServicelmpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderModel> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderModel> search(String term) {
        return orderRepository.findByCustomerModelCustomerNameContaining(term);
    }

    @Override
    public OrderModel findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public boolean update(OrderModel order) {
        OrderModel orderModel = orderRepository.findById(order.getId()).orElse(null);
        if (orderModel == null)
            return false;
        orderRepository.save(order);
        return true;
    }

    @Override
    public void save(OrderModel order) {
        orderRepository.save(order);
    }

    @Override
    public boolean delete(Long id) {
        OrderModel orderModel = orderRepository.findById(id).orElse(null);
        if (orderModel == null)
            return false;
        orderRepository.delete(orderModel);
        return true;
    }
}
