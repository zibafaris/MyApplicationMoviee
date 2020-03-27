package com.example.myapplicationmoviee.repository.di

import com.example.myapplicationmoviee.base.di.DataProvidersComponent
import com.example.myapplicationmoviee.repository.dbInteractor.MoviesDAO
import com.example.myapplicationmoviee.repository.networkInteractor.NetworkInteractor
import com.example.myapplicationmoviee.utills.CustomScope
import dagger.Component

// This class provides network and database classes for the repository class
@CustomScope
@Component(dependencies = [DataProvidersComponent::class])
interface DataProviderComponent {

    //Provides network interactor for project by Dagger

    fun getNetworkInteractor(): NetworkInteractor

    //Provides room db interactor by Dagger for project

    fun getDbInteractor(): MoviesDAO
}