package springframework.springwebfluxrest.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springframework.springwebfluxrest.domain.Category;
import springframework.springwebfluxrest.repositories.CategoryRepository;

public class CategoryControllerTest {

    WebTestClient webTestClient;
    CategoryRepository categoryRepository;
    CategoryController categoryController;
    @Before
    public void setUp() throws Exception {
        categoryRepository = Mockito.mock(CategoryRepository.class);
        categoryController = new CategoryController(categoryRepository);
        webTestClient = WebTestClient.bindToController(categoryController).build();
    }
    @Test
    public void list() {
        BDDMockito.given(categoryRepository.findAll()).willReturn(Flux.just(Category.builder().description("Cat1").build(),
        Category.builder().description("Cat2").build()));

        webTestClient.get().uri("/api/v1/categories/").exchange().expectBodyList(Category.class).hasSize(2);

    }

    @Test
    void getById() {
        BDDMockito.given(categoryRepository.findById("someid")).willReturn(Mono.just(Category.builder().description("Cat").build()));

        webTestClient.get().uri("/api/v1/categories/someid").exchange().expectBody(Category.class);
    }
}