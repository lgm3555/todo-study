package com.fastcampus.todokotlin.controller.dto

data class PostDetailResponse(
    var id: Long,
    val title: String,
    val content: String,
    val createdby: String,
    val createdAt: String
)
