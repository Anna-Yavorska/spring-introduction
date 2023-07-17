package javahome.springbootstudent.repository.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "shop")
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address_id")
    private Address addressId;
    @Column(name = "phone")
    private String phone;
    @OneToMany(
            mappedBy = "shop",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Employee> employees = new ArrayList<>();

    public Shop() {
    }

    public Shop(String name, Address addressId, String phone) {
        this.name = name;
        this.addressId = addressId;
        this.phone = phone;
    }

    public Shop(Integer id, String name, Address addressId, String phone) {
        this.id = id;
        this.name = name;
        this.addressId = addressId;
        this.phone = phone;
    }

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

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressId=" + addressId +
                ", phone='" + phone + '\'' +
                '}';
    }
}
