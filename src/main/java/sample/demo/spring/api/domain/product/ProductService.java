package sample.demo.spring.api.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.demo.spring.api.service.product.response.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductResponse> getSellingProducts() {
        List<Product> products = productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());

        return products.stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }
}
