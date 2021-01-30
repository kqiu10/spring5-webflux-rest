package springframework.springwebfluxrest.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springframework.springwebfluxrest.domain.Vendor;
import springframework.springwebfluxrest.repositories.VendorRepository;

public class VendorControllerTest {
    WebTestClient webTestClient;
    VendorController controller;
    VendorRepository vendorRepository;

    @Before
    public void setUp() throws Exception {
        vendorRepository = Mockito.mock(VendorRepository.class);
        controller = new VendorController(vendorRepository);
        webTestClient = WebTestClient.bindToController(controller).build();
    }

    @Test
    public void list() {
        BDDMockito.given(vendorRepository.findAll())
                .willReturn(Flux.just(Vendor.builder().firstName("Fred").LastName("Flinstone").build(),
                        Vendor.builder().firstName("Barney").LastName("Rubble").build()));
    }

    @Test
    public void getById() {
        BDDMockito.given(vendorRepository.findById("someid")).willReturn(Mono.just(Vendor.builder().firstName("Jimmy").LastName("Johns").build()));

        webTestClient.get()
                .uri("api/v1/vendors/someid")
                .exchange()
                .expectBody(Vendor.class);
    }
}