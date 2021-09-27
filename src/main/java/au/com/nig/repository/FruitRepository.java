package au.com.nig.repository;

import au.com.nig.entity.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository<FruitEntity, Long> {

    List<FruitEntity> findByColor(String color);
}
