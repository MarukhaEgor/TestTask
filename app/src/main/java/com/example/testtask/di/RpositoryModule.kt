package com.example.testtask.di

import com.example.testtask.data.Repository
import org.koin.core.module.Module
import org.koin.dsl.module

val repository: Module = module {
    single {
        Repository()
    }
}