package ru.shornikov.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.shornikov.entity.Book;


import java.util.List;


@Component
@ConfigurationProperties(prefix = "book")
@PropertySource(value="classpath:book.properties", encoding = "UTF-8")
public class BookProp {

    private List<String> manufacturelist;

    public void setManufacturelist(List<String> manufacturelist) {
        this.manufacturelist = manufacturelist;
    }

    public List<String> getManufacturelist() {
        return manufacturelist;
    }

    public String getManufacturelistDesc(int code){
        if(code>0 && manufacturelist.size() > code-1)
            return manufacturelist.get(code);
        else return  "Отсутсвует";

    }

}
