package com.valu.storeapp.di
import com.valu.storeapp.common.Constants.BASE_URL
import com.valu.storeapp.data.remote.Api
import com.valu.storeapp.data.repository.RepositoryImpl
import com.valu.storeapp.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit() :Api{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(api: Api): Repository {
        return RepositoryImpl(api)
    }

}