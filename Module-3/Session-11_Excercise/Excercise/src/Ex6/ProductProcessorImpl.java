package Ex6;

import java.util.List;

class ProductProcessorImpl implements ProductProcessor {
    @Override
    public double calculateTotalValue(List<Product> products) {
        return products.stream()
                       .mapToDouble(Product::getPrice)
                       .sum();
    }
}
