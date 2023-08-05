package pandey.com.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandey.com.bean.Book;
import pandey.com.dao.BookDao;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookdao;
    @Override
    public void processbook() {
        String filepath="D:\\Spring_Boot_Project\\BookApp\\books.txt";

       try
        {

            Stream<String> lines=Files.lines(Paths.get(filepath));
            lines.forEach(line -> {


              String[] values= line.split(",");

                String id=values[0];
                String name=values[1];
                String  price=values[2];

                Book b=new Book();
                b.setId(Integer.parseInt(values[0]));
                b.setName(values[1]);
                b.setPrice(Double.parseDouble(values[2]));

                int count=bookdao.insertBook(b);
                if(count>0)
                {
                    System.out.println("...record insert ....."+count);
                }

        });

        }catch (Exception e)
       {
           e.printStackTrace();
       }



    }
}
