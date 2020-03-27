package com.example.myapplicationmoviee.base

import android.app.Application
import com.example.myapplicationmoviee.base.di.DaggerDataProvidersComponent
import com.example.myapplicationmoviee.base.di.DataProvidersComponent
import com.example.myapplicationmoviee.base.di.RoomModule
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Logger.addLogAdapter(AndroidLogAdapter())

        component = DaggerDataProvidersComponent.builder().roomModule(RoomModule(this)).build()

    }

    companion object {
        private lateinit var component: DataProvidersComponent


       // Provides DataProvidersComponent

        fun getDataProviderComponent(): DataProvidersComponent {
            return component
        }

    }
}