package controller;

import com.example.session03.model.Author;
import com.example.session03.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")

public class AuthorController {
    private final AuthorService authorService;

    // Inject Service vào Controller
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // Endpoint: GET /api/v1/authors
    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    // su dụng dấu '?' để khai báo chưa biết trước kiểu dữ liệu trả về , có thể là trả về Author hoặc 1 chuỗi
    public ResponseEntity<?> getAuthor(@PathVariable int id) {
        Author author = authorService.getAuthorById(id);
        if (author == null) {
            return ResponseEntity.status(404).body("Không tìm thấy tác giả với ID: " + id);
        }
        return ResponseEntity.ok(author);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable int id, @RequestBody Author author) {
        Author result = authorService.updateAuthor(id,author);
        if (result == null) {
            return new ResponseEntity<>("Không tìm thấy tác gi với id : " + id, HttpStatus.NOT_FOUND);
        }else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Author>> searchAuthor(@RequestParam("name") String keyword){
        return new ResponseEntity<>(authorService.searchAuthors(keyword), HttpStatus.OK);
    }
}
