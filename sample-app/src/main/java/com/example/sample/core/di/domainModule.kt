@file:Suppress("RemoveExplicitTypeArguments")

package com.example.sample.core.di

import com.example.sample.domain.repository.AuthorRepository
import com.example.sample.domain.repository.BookRepository
import com.example.sample.domain.useCase.GetAuthor
import com.example.sample.domain.useCase.GetAuthors
import com.example.sample.domain.useCase.GetBook
import com.example.sample.domain.useCase.GetBooks
import org.koin.dsl.module

val domainModule = module {
    single { GetBooks(get<BookRepository>()) }
    single { GetBook(get<BookRepository>()) }

    single { GetAuthors(get<AuthorRepository>()) }
    single { GetAuthor(get<AuthorRepository>()) }
}
