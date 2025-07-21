import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2); // удали 2 товар

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3}; // должны остатся 1 и 3 товар

        Assertions.assertArrayEquals(expected, actual);

    }

  /*  @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(5); // удали 5 товар

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3}; // должны остатся 1 и 3 товар

        Assertions.assertArrayEquals(expected, actual);

    }*/

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(
                NotFoundException.class, // Проверка исключения
                () -> repo.remove(1234)
                );

    }

}