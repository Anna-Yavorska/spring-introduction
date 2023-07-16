package javahome.springbootstudent.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address_id")
    private Integer addressId;
    @Column(name = "phone")
    private String phone;

    public Shop() {
    }

    public Shop(String name, Integer addressId, String phone) {
        this.name = name;
        this.addressId = addressId;
        this.phone = phone;
    }

    public Shop(Integer id, String name, Integer addressId, String phone) {
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
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressId=" + addressId +
                ", phone='" + phone + '\'' +
                '}';
    }
}
