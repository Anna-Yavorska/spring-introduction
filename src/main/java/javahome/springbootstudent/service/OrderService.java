package javahome.springbootstudent.service;

import javahome.springbootstudent.controller.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAll();

    OrderDTO getById(Integer orderId);

    Integer createOrder(OrderDTO orderDTO);

    void deleteOrder(Integer orderId);
}
