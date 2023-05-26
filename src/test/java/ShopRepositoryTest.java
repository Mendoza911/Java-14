import org.example.NotFoundException;
import org.example.Product;
import org.example.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void ShouldtThrowException () {

        ShopRepository repository = new ShopRepository();

        Product product = new Product(2, "eggs", 78);

        repository.add(new Product(1, "milk", 123));
        repository.add(product);
        repository.add(new Product(3, "bread", 45));

        Assertions.assertEquals(product, repository.findById(2));

        repository.remove(2);

        Assertions.assertNull(repository.findById(2));

    }

    @Test
    public void ShouldThrowException () {

        ShopRepository repository = new ShopRepository();

        repository.add(new Product(1, "milk", 123));
        repository.add(new Product(2, "eggs", 78));
        repository.add(new Product(3, "bread", 45));

        repository.remove(4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.remove(4);
        });

    }


}
