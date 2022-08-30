package ru.shornikov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shornikov.entity.Book;
import ru.shornikov.entity.BookViev;
import ru.shornikov.properties.BookProp;
import ru.shornikov.сondition.ConditionDev;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@RestController("BookService")
@RequestMapping("/books")
@Conditional(ConditionDev.class)
public class BookControllerLocal implements BookController {

    private List<Book> LocalBooks = new ArrayList<>();
    @Autowired
    BookProp bookProp;

    @Autowired
    public BookControllerLocal() {
        System.out.println("Create BookServiceLocal");
    }

    @Override
    @GetMapping("/all")
    public List<Book> getAllPeople() {
        return  LocalBooks;
    }

    @Value("${build_desc}")
    private String build_desc;

    @Override
    @GetMapping("/create")
    public String createwindow() {
        return "<h3>"+build_desc+"</h3><a href=\"/books/allMirror\">Просмотр книг</a><form action=\"/books/createbook\" method=\"GET\">   <div>     <label for=\"name\">Name</label>     <input name=\"name\" id=\"name\">   </div>   <div>     <label for=\"manufacture\">Manufacture</label>     <input name=\"manufacture\" id=\"manufacture\" value=\"1\">   </div>   <div>     <button>Create</button>   </div> </form>";
    }

    @Override
    @GetMapping("/createbook")
    public String createbook(Book book) {

        LocalBooks.add(book);
        return "<script>document.location.replace(\"/books/create\");</script>";
    }

    @Override
    @GetMapping("/allMirror")
    public String getAllPeopleMirror() {
        String table = "<a href=\"/books/create\">Назад</a><table border='1'><caption>Книги</caption><tr><th>ID</th><th>Имя</th><th>Дата</th><th>Производитель</th></tr>";
        for(Book book : LocalBooks){
            table+="<tr><td>"+book.getId()+"</td><td>"+book.getName()+"</td><td>"+book.getCreatedate()+"</td><td>"+bookProp.getManufacturelistDesc(book.getManufacture())+"</td></tr>";
        }
        return table+"</table>";
    }
}
