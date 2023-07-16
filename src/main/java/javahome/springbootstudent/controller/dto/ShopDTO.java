package javahome.springbootstudent.controller.dto;

import java.util.Objects;

public class ShopDTO {
    private Integer id;
    private String name;
    private Integer addressId;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopDTO shopDTO = (ShopDTO) o;
        return Objects.equals(id, shopDTO.id) && Objects.equals(name, shopDTO.name) && Objects.equals(addressId, shopDTO.addressId) && Objects.equals(phone, shopDTO.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addressId, phone);
    }

    @Override
    public String toString() {
        return "ShopDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressId=" + addressId +
                ", phone='" + phone + '\'' +
                '}';
    }
}
