package springframework.springwebfluxrest.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.springwebfluxrest.domain.Category;
import springframework.springwebfluxrest.domain.Vendor;
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

            System.out.println("### LOADING DATA ON BOOTSTRAP #####");
            categoryRepository.save(Category.builder().description("Nuts").build());

            System.out.println("### LOADING DATA ON BOOTSTRAP #####");
            categoryRepository.save(Category.builder().description("Meats").build());

            System.out.println("### LOADING DATA ON BOOTSTRAP #####");
            categoryRepository.save(Category.builder().description("Eggs").build());

            System.out.println("Loaded Categories " + categoryRepository.count().block());

            vendorRepository.save(Vendor.builder().firstName("Joe").LastName("Buck").build());

            vendorRepository.save(Vendor.builder().firstName("Micheal").LastName("Weston").build());

            vendorRepository.save(Vendor.builder().firstName("Michale").LastName("Jacky").build());

            vendorRepository.save(Vendor.builder().firstName("Greg").LastName("Mick").build());

            System.out.println("Loaded vendors " + vendorRepository.count().block());


        }
    }
}
