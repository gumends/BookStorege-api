package com.bookstorage.prod.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "tb_bookies")
public class BookModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherModel publisher;

    @ManyToMany
    @JoinTable(
            name = "tb_book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<AuthorModel> authors = new HashSet<>();

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private ReviewsModel review;

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publisher=" + publisher +
                ", authors=" + authors +
                ", review=" + review +
                '}';
    }
}
