package springframework.springwebfluxrest.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import springframework.springwebfluxrest.domain.Category;

/**
 * Date: 1/29/21
 * Question Description
 */

public interface CategoryRepository extends ReactiveMongoRepository <Category, String> {


}
