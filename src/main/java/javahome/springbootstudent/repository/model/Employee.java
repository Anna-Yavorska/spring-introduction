package javahome.springbootstudent.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @ManyToOne
    private Shop shop;
    @Column(name = "title")
    private String title;

    public Employee() {
    }

    public Employee(String name, String surname, Shop shop, String title) {
        this.name = name;
        this.surname = surname;
        this.shop = shop;
        this.title = title;
    }

    public Employee(Integer id, String name, String surname, Shop shop, String title) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.shop = shop;
        this.title = title;
    }

    public Integer getId()
    {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", shopId=" + shop +
                ", title='" + title + '\'' +
                '}';
    }
}
