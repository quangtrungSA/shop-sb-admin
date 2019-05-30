package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.OrderDetailModel;
import vn.edu.leading.shop.repositories.OrderDetailRepository;

import java.util.List;

@Service
public class OrderDetailServicelmpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailServicelmpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetailModel> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public List<OrderDetailModel> search(Long id) {
        return orderDetailRepository.findByOrderModelOrderById(id);
    }

    @Override
    public OrderDetailModel findById(Long id) {
        return orderDetailRepository.findById(id).get();
    }

    @Override
    public boolean update(OrderDetailModel orderDetail) {
        OrderDetailModel orderDetailModel = orderDetailRepository.findById(orderDetail.getId()).orElse(null);
        if (orderDetailModel == null)
            return false;
        orderDetailRepository.save(orderDetail);
        return true;
    }

    @Override
    public void save(OrderDetailModel orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public boolean delete(Long id) {
        OrderDetailModel orderDetailModel = orderDetailRepository.findById(id).orElse(null);
        if (orderDetailModel == null)
            return false;
        orderDetailRepository.delete(orderDetailModel);
        return true;
    }
}
