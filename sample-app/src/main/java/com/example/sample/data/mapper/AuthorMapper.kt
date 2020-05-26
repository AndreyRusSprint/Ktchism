package com.example.sample.data.mapper

import com.example.sample.data.model.AuthorLocal
import com.example.sample.domain.entity.Author

fun AuthorLocal.toDomain(): Author = Author(id, name)
