package au.com.nig.service;

import au.com.nig.entity.FruitEntity;
import au.com.nig.model.Fruit;
import au.com.nig.repository.FruitRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FruitService {

    @Inject
    private FruitRepository service;

    public List<Fruit> fetchFruits() {
        List<FruitEntity> entities = service.findAll();
        return transformFruits(entities);
    }

    protected static List<Fruit> transformFruits(List<FruitEntity> entities) {
        return entities
                .stream()
                .map(fruit -> new Fruit(fruit.getName()))
                .collect(Collectors.toList());
    }
}
