package au.com.nig.controller;

import au.com.nig.model.Fruit;
import au.com.nig.service.FruitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    private final FruitService service;

    public FruitController(FruitService service) {
        this.service = service;
    }

    @GetMapping
    public List<Fruit> fetchFruits() {
        return service.fetchFruits();
    }

    @GetMapping("/{fruit}")
    public Fruit fetchFruit(@PathVariable(name = "fruit") String fruit) {

        return new Fruit(fruit);
    }
}
