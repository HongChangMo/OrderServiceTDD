package sample.cafekiosk.spring.api.service.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sample.cafekiosk.spring.IntegrationTestSupport;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductRepository;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.domain.product.ProductType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductNumberFactoryTest extends IntegrationTestSupport {

    @Autowired
    private ProductRepository productRepository;

    @AfterEach
    void tearDown() {
        productRepository.deleteAllInBatch();
    }

    @DisplayName("가장 최근 저장된 상품 번호보다 1만큼 증가한 상품번호를 출력한다.")
    @Test
    void createNextProductNumber() {
        // given
        Product product = Product.builder()
                .productNumber("001")
                .type(ProductType.HANDMADE)
                .sellingStatus(ProductSellingStatus.SELLING)
                .name("아메리카노")
                .price(2000)
                .build();

        productRepository.save(product);

        // when
        String latestProductNumber = productRepository.findLatestProductNumber();

        int latestNumber = Integer.parseInt(latestProductNumber);
        int nextNumber = latestNumber + 1;

        String nextProductNumber = String.format("%03d", nextNumber);

        // then
        assertThat(nextProductNumber).isEqualTo("002");
    }


    @DisplayName("가장 최근 저장된 상품이 없는 경우 001을 리턴한다.")
    @Test
    void createNextProductNumberIsEmpty() {
        // given
        String latestProductNumber = productRepository.findLatestProductNumber();

        // when
        if( latestProductNumber == null ) latestProductNumber = "001";

        // then
        assertThat(latestProductNumber).isEqualTo("001");
    }

}