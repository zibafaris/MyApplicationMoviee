package com.example.myapplicationmoviee.base.di

import com.example.myapplicationmoviee.base.BaseViewModelFactory
import com.example.myapplicationmoviee.repository.DataRepository
import dagger.Component

@Component
interface DataRepositoryComponent {

    fun getDataRepository(): DataRepository

    fun getBaseViewModel(): BaseViewModelFactory
}