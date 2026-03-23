package Ex5;
import java.util.ArrayList;
import java.util.List;

public class CategoryManagement implements ICRUD {
    private List<Category> categories = new ArrayList<>();

    @Override
    public Category[] findAll() {
        // Chuyển List thành Array để trả về theo đúng kiểu của Interface
        return categories.toArray(new Category[0]);
    }

    @Override
    public void addCategory(Category category) {
        categories.add(category);
    }

    @Override
    public void updateCategory(Category category) {
        for (Category c : categories) {
            if (c.getId() == category.getId()) {
                c.setName(category.getName());
                c.setDescription(category.getDescription());
                return;
            }
        }
    }

    @Override
    public void deleteById(int id) {
        categories.removeIf(c -> c.getId() == id);
    }
}
