package com.ugo.author.author;

import com.ugo.author.author.helpers.AuthorDto;
import com.ugo.author.author.helpers.AuthorRequest;
import com.ugo.author.author.helpers.AuthorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional
    public void createAuthor(@Valid AuthorRequest authorRequest) {
        Author author = Author.builder()
            .name(authorRequest.getName())
            .email(authorRequest.getEmail())
            .build();
        authorRepository.save(author);
    }

    public AuthorDto getAuthor(Long id) {
        Author author = authorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Author not found"));
        return new AuthorMapper().apply(author);
    }

    public Page<AuthorDto> getAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable)
                .map(new AuthorMapper());
    }
}
