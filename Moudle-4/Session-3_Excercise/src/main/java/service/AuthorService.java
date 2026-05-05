package service;

import com.example.session03.model.Author;
import com.example.session03.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AuthorService {
    private final AuthorRepository authorRepository;

    // Sử dụng Constructor Injection (Khuyên dùng thay vì @Autowired trên field)
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        // Có thể thêm logic xử lý dữ liệu ở đây nếu cần trước khi trả về
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author) {
        authorRepository.save(author);
        return author;
    }

    public Author getAuthorById(int id){
        return authorRepository.findById(id);
    }

    public Author updateAuthor(int id ,Author author){
        Author checkExists = authorRepository.findById(id);
        if(checkExists != null){
            return authorRepository.update(author);
        }else {
            return null ;
        }
    }

    public List<Author> searchAuthors(String keyword){
        List<Author> authors = authorRepository.findAll();
        return authors.stream().filter(auth -> auth.getName().toLowerCase().contains(keyword.toLowerCase())).toList();
    }
}
