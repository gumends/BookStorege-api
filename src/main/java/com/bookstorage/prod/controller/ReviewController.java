package com.bookstorage.prod.controller;

import com.bookstorage.prod.models.PublisherModel;
import com.bookstorage.prod.models.ReviewsModel;
import com.bookstorage.prod.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("review")
public class ReviewController {

    @Autowired
    private ReviewsService reviewsService;

    @PostMapping("/save")
    public ResponseEntity<ReviewsModel> save(@RequestBody ReviewsModel reviewsModel){
        return ResponseEntity.ok(reviewsService.save(reviewsModel));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReviewsModel>> all(){
        return ResponseEntity.ok(reviewsService.getAll());
    }
}
