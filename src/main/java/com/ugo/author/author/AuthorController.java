package com.ugo.author.author;

import com.ugo.author.author.helpers.AuthorDto;
import com.ugo.author.author.helpers.AuthorRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/author")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<AuthorDto> getAuthors(@PageableDefault (size=10, page=0, sort="id")
                                          Pageable pageable) {
        return authorService.getAuthors(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAuthor(@RequestBody @Valid AuthorRequest authorRequest) {
        authorService.createAuthor(authorRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDto getAuthor(@PathVariable Long id) {
        return authorService.getAuthor(id);
    }
}
