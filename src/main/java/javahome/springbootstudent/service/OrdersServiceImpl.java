package javahome.springbootstudent.service;

import javahome.springbootstudent.controller.dto.OrderDTO;
import javahome.springbootstudent.converter.OrderConverter;
import javahome.springbootstudent.exception.NotFoundException;
import javahome.springbootstudent.repository.OrderRepository;
import javahome.springbootstudent.repository.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrdersServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    public OrdersServiceImpl(OrderRepository orderRepository, OrderConverter orderConverter) {
        this.orderRepository = orderRepository;
        this.orderConverter = orderConverter;
    }

    @Override
    public List<OrderDTO> getAll() {
        List<Order> all = orderRepository.findAll();
        return orderConverter.convertToDTO(all);
    }

    @Override
    public OrderDTO getById(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("Order not found: " + orderId));
        return orderConverter.convertToDTO(order);
    }

    @Override
    public Integer createOrder(OrderDTO orderDTO) {
        Order order = orderConverter.convertToEntity(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return savedOrder.getId();
    }

    @Override
    public void deleteOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("Order not found: " + orderId));
        orderRepository.delete(order);
    }
}
