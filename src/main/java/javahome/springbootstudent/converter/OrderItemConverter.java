package javahome.springbootstudent.converter;

import javahome.springbootstudent.controller.dto.OrderItemDTO;

import javahome.springbootstudent.repository.model.Order;
import javahome.springbootstudent.repository.model.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderItemConverter {
    private final ProductConverter productConverter;

    public OrderItemConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    public List<OrderItem> convertToEntity(List<OrderItemDTO> orderItem, Order order) {
        return orderItem.stream()
                .map(item -> convertToEntity(item, order))
                .toList();
    }

    private OrderItem convertToEntity(OrderItemDTO source, Order order) {
        OrderItem result = new OrderItem();
        result.setOrder(order);
        result.setProduct(productConverter.convertToEntity(source.getProduct()));
        result.setQuantity(source.getQuantity());
        return result;
    }

    public List<OrderItemDTO> convertToDTO(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(this::convertToDTO)
                .toList();
    }

    private OrderItemDTO convertToDTO(OrderItem orderItem) {
        OrderItemDTO result = new OrderItemDTO();
        result.setId(orderItem.getId());
        result.setOrderId(orderItem.getOrder().getId());
        result.setProduct(productConverter.convertToProductDTO(orderItem.getProduct()));
        result.setQuantity(orderItem.getQuantity());
        return result;
    }
}
