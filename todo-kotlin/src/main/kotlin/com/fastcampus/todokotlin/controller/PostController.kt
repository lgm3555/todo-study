package com.fastcampus.todokotlin.controller

import com.fastcampus.todokotlin.controller.dto.PostCreateRequest
import com.fastcampus.todokotlin.controller.dto.PostDetailResponse
import com.fastcampus.todokotlin.controller.dto.PostUpdateRequest
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class PostController {

    @PostMapping("/posts")
    fun createPost(
        @RequestBody postCreateRequest: PostCreateRequest
    ): Long {
        return 1L;
    }

    @PutMapping("/posts/{id}")
    fun updatePost(
        @PathVariable("id") id: Long,
        @RequestBody postUpdateRequest: PostUpdateRequest
    ): Long {
        return 1L;
    }

    @DeleteMapping("/posts/{id}")
    fun deletePost(
        @PathVariable("id") id: Long,
        @RequestParam createdBy: String
    ): Long {
        println(createdBy)
        return id;
    }

    @GetMapping("/posts/{id}")
    fun getPost(
        @PathVariable("id") id: Long,
    ): PostDetailResponse {
        return PostDetailResponse(1L, "title", "content", "createdBy", LocalDateTime.now().toString());
    }
}
