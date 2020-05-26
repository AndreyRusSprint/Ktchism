package com.example.sample.core.di

import com.example.sample.data.dataSource.AuthorLocalDataStore
import com.example.sample.data.dataSource.BookLocalDataStore
import org.koin.dsl.module

val dataSourceModule = module {
    single { AuthorLocalDataStore() }
    single { BookLocalDataStore() }
}
