package com.fastcampus.todokotlin.controller.dto

data class PostCreateRequest(
    val title: String,
    val content: String,
    val createdBy: String
)
