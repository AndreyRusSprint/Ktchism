package com.example.sample.data.mapper

import com.example.sample.data.model.BookLocal
import com.example.sample.domain.entity.Book

fun BookLocal.toDomain(): Book = Book(id, name, author.toDomain())
