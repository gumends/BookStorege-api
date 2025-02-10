package com.bookstorage.prod.controller;

import com.bookstorage.prod.dto.ReviewDTO;
import com.bookstorage.prod.models.PublisherModel;
import com.bookstorage.prod.models.ReviewsModel;
import com.bookstorage.prod.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("review")
public class ReviewController {

    @Autowired
    private ReviewsService reviewsService;

    @PostMapping("/save")
    public ResponseEntity<ReviewsModel> save(@RequestBody ReviewDTO reviewDTO){
        return ResponseEntity.ok(reviewsService.save(reviewDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReviewsModel>> all(){
        return ResponseEntity.ok(reviewsService.getAll());
    }

    @GetMapping("/{id}")
    public ReviewsModel getById(UUID id){
        return reviewsService.getById(id);
    }

    @PatchMapping("/{id}")
    public ReviewsModel patchById(@PathVariable UUID id, @RequestBody ReviewDTO reviewDTO){
        return reviewsService.patchById(id, reviewDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(UUID id){
        reviewsService.deleteById(id);
    }

}
