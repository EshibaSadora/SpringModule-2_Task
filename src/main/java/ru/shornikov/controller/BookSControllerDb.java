package ru.shornikov.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shornikov.entity.Book;
import ru.shornikov.entity.BookViev;
import ru.shornikov.properties.BookProp;
import ru.shornikov.repository.BookRepository;
import ru.shornikov.сondition.ConditionProd;


@RestController("BookService")
@RequestMapping("/books")
@Conditional(ConditionProd.class)
public class BookSControllerDb implements BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public void BookServiceDb() {
        System.out.println("Create BookServiceDb");
    }

    @Override
    @GetMapping("/all")
    public List<Book> getAllPeople() {
        return bookRepository.findAll();
    }

    @Autowired
    BookProp bookProp;

    @Override
    @GetMapping("/allMirror")
    public String getAllPeopleMirror() {
        String table = "<a href=\"/books/create\">Назад</a><table border='1'><caption>Книги</caption><tr><th>ID</th><th>Имя</th><th>Дата</th><th>Производитель</th></tr>";
        for(Book book : bookRepository.findAll()){
            table+="<tr><td>"+book.getId()+"</td><td>"+book.getName()+"</td><td>"+book.getCreatedate()+"</td><td>"+bookProp.getManufacturelistDesc(book.getManufacture())+"</td></tr>";
        }
        return table+"</table>";
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
        book.setCreatedate(new Date());
        bookRepository.save(book);
        return "<script>document.location.replace(\"/books/create\");</script>";
    }
}
