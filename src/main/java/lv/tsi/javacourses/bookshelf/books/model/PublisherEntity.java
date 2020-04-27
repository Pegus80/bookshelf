package lv.tsi.javacourses.bookshelf.books.model;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "Publisher")
@Table(name = "publishers")


public class PublisherEntity {
    @Id
    @GeneratedValue
    Long id;

    @Size(min=3, message = "Minimum 3 symbols")
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "country", length = 100, nullable = false)
    private String country;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "street", length = 100)
    private String street;

    @Column(name = "house", length = 10)
    private String house;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}
