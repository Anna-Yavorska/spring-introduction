package javahome.springbootstudent.controller.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderDTO {
    private Integer id;
    private UserDTO user;
    private Date createdAt;
    private String comment;
    private List<OrderItemDTO> orderItems = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id) && Objects.equals(user, orderDTO.user) && Objects.equals(createdAt, orderDTO.createdAt) && Objects.equals(comment, orderDTO.comment) && Objects.equals(orderItems, orderDTO.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, createdAt, comment, orderItems);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", user=" + user +
                ", createdAt=" + createdAt +
                ", comment='" + comment + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
