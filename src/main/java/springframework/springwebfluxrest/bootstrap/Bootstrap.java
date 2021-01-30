package springframework.springwebfluxrest.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.springwebfluxrest.domain.Category;
import springframework.springwebfluxrest.repositories.CategoryRepository;
import springframework.springwebfluxrest.repositories.VendorRepository;

/**
 * Date: 1/30/21
 * Question Description
 */
@Component
public class Bootstrap implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count().block() == 0) {
            System.out.println("### LOADING DATA ON BOOTSTRAP #####");
            categoryRepository.save(Category.builder().description("Fruits").build());
        }
    }
}
