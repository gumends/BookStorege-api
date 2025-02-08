package com.bookstorage.prod.service;

import com.bookstorage.prod.models.ReviewsModel;
import com.bookstorage.prod.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("review")
public class ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    public ReviewsModel save(ReviewsModel reviewsModel){
        return reviewsRepository.save(reviewsModel);
    }

    public List<ReviewsModel> getAll(){
        return reviewsRepository.findAll();
    }

}
