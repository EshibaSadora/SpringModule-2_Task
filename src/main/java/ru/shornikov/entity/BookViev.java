package ru.shornikov.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.shornikov.properties.BookProp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Component
public class BookViev {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ID", nullable = false)
    private UUID id;

    //Название

    private String name;

    //год издания

    private Date createdate;

    //Производитель

    private String manufacture;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public BookViev() {
    }


    public BookViev(Book book, BookProp bookProp) {
        this.id = book.getId();
        this.name = book.getName();
        this.createdate =  book.getCreatedate();
        this.manufacture = bookProp.getManufacturelistDesc(book.getManufacture());
    }


}
