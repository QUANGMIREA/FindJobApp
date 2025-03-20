package com.example.myapplication.DataClass

data class JobResponse(
    val data: List<Job>,
    val links: Links,
    val meta: Meta
)

data class Job(
    val slug: String,
    val company_name: String,
    val title: String,
    val description: String,
    val remote: Boolean,
    val url: String,
    val tags: List<String>,
    val job_types: List<String>,
    val location: String,
    val created_at: Long
)

data class Links(
    val next: String?,
    val prev: String?
)

data class Meta(
    val current_page: Int,
    val path: String,
    val per_page: Int,
    val total: Int
)