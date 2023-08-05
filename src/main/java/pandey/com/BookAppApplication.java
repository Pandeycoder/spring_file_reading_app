package pandey.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pandey.com.service.BookService;

@SpringBootApplication
public class BookAppApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context= SpringApplication.run(BookAppApplication.class, args);

		BookService bookService=context.getBean(BookService.class);
		bookService.processbook();

	}

}
