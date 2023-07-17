package javahome.springbootstudent.converter;

import javahome.springbootstudent.controller.dto.OrderDTO;
import javahome.springbootstudent.repository.model.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class OrderConverter {
    private final UserConverter userConverter;
    private final OrderItemConverter orderItemConverter;

    public OrderConverter(UserConverter userConverter, OrderItemConverter orderItemConverter) {
        this.userConverter = userConverter;
        this.orderItemConverter = orderItemConverter;
    }

    public Order convertToEntity(OrderDTO source) {
        Order result = new Order();
        result.setUser(userConverter.convertToEntity(source.getUser()));
        result.setOrderItems(orderItemConverter.convertToEntity(source.getOrderItems(), result));
        result.setCreatedAt(source.getCreatedAt());
        result.setComment(source.getComment());
        return result;
    }

    public OrderDTO convertToDTO(Order order) {
        return convertOrderToDto(order);
    }

    public List<OrderDTO> convertToDTO(Collection<Order> orders) {
        return orders.stream()
                .map(this::convertOrderToDto)
                .toList();
    }

    private OrderDTO convertOrderToDto(Order source) {
        OrderDTO result = new OrderDTO();
        result.setId(source.getId());
        result.setCreatedAt(source.getCreatedAt());
        result.setUser(userConverter.convertToDTO(source.getUser()));
        result.setOrderItems(orderItemConverter.convertToDTO(source.getOrderItems()));
        result.setComment(source.getComment());
        return result;
    }
}
