package com.bookstorage.prod.service;

import com.bookstorage.prod.dto.ReviewDTO;
import com.bookstorage.prod.models.ReviewsModel;
import com.bookstorage.prod.repository.BookRepository;
import com.bookstorage.prod.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("review")
public class ReviewsService {

    @Autowired
    private final ReviewsRepository reviewsRepository;
    @Autowired
    private final BookRepository bookRepository;

    public ReviewsService(ReviewsRepository reviewsRepository, BookRepository bookRepository) {
        this.reviewsRepository = reviewsRepository;
        this.bookRepository = bookRepository;
    }

    public ReviewsModel save(ReviewDTO reviewDTO){
        ReviewsModel reviewsModel = new ReviewsModel();
        reviewsModel.setName(reviewDTO.name());
        reviewsModel.setBook(bookRepository.findById(reviewDTO.bookId()).orElseThrow());

        return reviewsRepository.save(reviewsModel);
    }

    public List<ReviewsModel> getAll(){
        return reviewsRepository.findAll();
    }

    public ReviewsModel getById(UUID id){
        return reviewsRepository.findById(id).orElseThrow();
    }

    public ReviewsModel patchById(UUID id, ReviewDTO reviewDTO){
        ReviewsModel patch = getById(id);

        if (reviewDTO.name() != null){
            patch.setName(reviewDTO.name());
        }
        if (reviewDTO.bookId() != null){
            patch.setBook(bookRepository.findById(reviewDTO.bookId()).orElseThrow());
        }

        return reviewsRepository.save(patch);
    }

    public void deleteById(UUID id){
        reviewsRepository.deleteById(id);
    }
}
