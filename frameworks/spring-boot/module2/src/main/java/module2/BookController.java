package module2;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
 
 
@RestController
public class BookController {
	
	@RequestMapping(value = "/book2",method = RequestMethod.GET)
	@ResponseBody
    public Book getBook() {
    	Book book = new Book();
    	book.setBookId(112);
    	book.setBookName("i am book two");
    	book.setBookPrice("22");
    	return book;
	}
}
