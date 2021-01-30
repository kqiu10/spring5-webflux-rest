package springframework.springwebfluxrest.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import springframework.springwebfluxrest.domain.Vendor;

/**
 * Date: 1/30/21
 * Question Description
 */

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {

}
