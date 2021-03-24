package com.lamnt.foodorder.di

import android.content.Context
import android.content.SharedPreferences
import com.lamnt.foodorder.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun providePref(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(Constant.PREF_NAME, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun providePrefEditor(sharedPreferences: SharedPreferences): SharedPreferences.Editor =
        sharedPreferences.edit()


}