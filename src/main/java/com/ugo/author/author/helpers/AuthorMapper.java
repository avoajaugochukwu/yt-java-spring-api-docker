package com.ugo.author.author.helpers;

import com.ugo.author.author.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class AuthorMapper implements Function<Author, AuthorDto> {
    @Override
    public AuthorDto apply(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .email(author.getEmail())
                .build();
    }
}
