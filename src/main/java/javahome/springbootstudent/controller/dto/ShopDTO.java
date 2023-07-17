package javahome.springbootstudent.controller.dto;

import javahome.springbootstudent.repository.model.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShopDTO {
    private Integer id;
    private String name;
    private AddressDTO address;
    private String phone;

    private List<EmployeeDTO> employees = new ArrayList<>();

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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
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
        return Objects.equals(id, shopDTO.id) && Objects.equals(name, shopDTO.name) && Objects.equals(address, shopDTO.address) && Objects.equals(phone, shopDTO.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phone);
    }

    @Override
    public String toString() {
        return "ShopDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressId=" + address +
                ", phone='" + phone + '\'' +
                '}';
    }
}
