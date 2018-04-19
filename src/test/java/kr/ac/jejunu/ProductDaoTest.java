package kr.ac.jejunu;

import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ProductDaoTest {
    public void setup() {
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        ProductDao productDao = new ProductDao();
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        Product product = productDao.get(id);
        assertEquals(id, product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(price, product.getPrice());
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        ProductDao productDao = new ProductDao();
        Product product = new Product();

        product.setTitle("한라봉");
        product.setPrice(20000);
        Long id = productDao.insert(product);

        Product insertedproduct = productDao.get(id);
        assertEquals(id, insertedproduct.getId());
        assertEquals(product.getTitle(), insertedproduct.getTitle());
        assertEquals(product.getPrice(),insertedproduct.getPrice());
    }
}
