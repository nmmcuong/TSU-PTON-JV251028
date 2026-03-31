package Ex6;

class ProductProcessorImpl implements ProductProcessor {
    @Override
    public double calculateTotalValue(List<Product> products) {
        return products.stream()
                       .mapToDouble(Product::getPrice)
                       .sum();
    }
}
