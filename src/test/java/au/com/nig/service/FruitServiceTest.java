package au.com.nig.service;

import au.com.nig.entity.FruitEntity;
import au.com.nig.model.Fruit;
import au.com.nig.repository.FruitRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class FruitServiceTest {

    @Inject
    private FruitService fruitService;

    @InjectMock
    private FruitRepository repository;

    @Test
    public void test_how_to_test_a_static_function() {
        // Given
        FruitEntity entity = new FruitEntity("Apple", "red");
        List<Fruit> expectedResult = List.of(new Fruit("Apple"));

        // When
        List<Fruit> fruits = FruitService.transformFruits(List.of(entity));

        // Then
        assertEquals(expectedResult, fruits);
//        assertFalse(true);
    }

    @Test
    public void test_with_mock() {
        // Given
        FruitEntity entity = new FruitEntity("Apple", "red");
        List<Fruit> expectedResult = List.of(new Fruit("Apple"));
        Mockito.when(repository.findAll()).thenReturn(List.of(entity));

        // When
        List<Fruit> fruits = fruitService.fetchFruits();

        // Then
        assertEquals(expectedResult, fruits);
    }

}
