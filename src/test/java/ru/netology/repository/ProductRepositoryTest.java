package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();

    private Product first = new Book(1, "Summer", 155, "Abc");
    private Product second = new Book(2, "Winter", 200, "Abc");
    private Product third = new Book(3, "Spring", 70000, "Abc");
    private Product forth = new Book(4, "Autumn", 30, "Xyz");
    private Product fifth = new Smartphone(5, "Iphone12", 80000, "Apple");
    private Product sixth = new Smartphone(6, "Iphone11", 60000, "Apple");
    private Product seventh = new Smartphone(7, "Honor", 30000, "Huawei");

    @BeforeEach
    public void setting() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
    }

    @Test
    public void shouldRemoveIfExists(){

        repository.removeById(5);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, third, forth, sixth, seventh};

        assertArrayEquals(actual, expected);

     }

    @Test
    public void shouldShowExceptionIfNotExist(){

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(10);
        });
    }

}