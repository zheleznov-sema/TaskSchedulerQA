package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldRemoveById() {
        ShopRepository repo = new ShopRepository();

        Product p1 = new Product(1, "Хлеб", 50);
        Product p2 = new Product(2, "Молоко", 80);
        Product p3 = new Product(3, "Мясо", 300);

        repo.add(p1);
        repo.add(p2);
        repo.add(p3);

        repo.removeById(2);

        Product[] expected = { p1, p3 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundException() {
        ShopRepository repo = new ShopRepository();

        Product p1 = new Product(1, "Хлеб", 50);
        Product p2 = new Product(2, "Молоко", 80);

        repo.add(p1);
        repo.add(p2);

        Assertions.assertThrows(
                NotFoundException.class,
                () -> repo.removeById(999)
        );
    }


}
