import com.zhao.could.product.ProductApplication;
import com.zhao.could.product.service.IProductService;
import com.zhao.could.product.vo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = ProductApplication.class)
@RunWith(SpringRunner.class)
public class TestProduct {

    @Autowired
    IProductService iProductService;

    @Test
    public void list(){
        List<Product> list=iProductService.list();
        for (Product product:list) {
            System.out.println(product);
        }
    }
}
