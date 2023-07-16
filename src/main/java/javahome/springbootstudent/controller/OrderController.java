package javahome.springbootstudent.controller;

import javahome.springbootstudent.controller.dto.OrderDTO;
import javahome.springbootstudent.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public OrderDTO getById(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @PostMapping
    public Integer createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
    }
}
