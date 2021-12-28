package com.example.shoppinglist

import android.app.Application
import com.example.shoppinglist.data.db.ShoppingDataBase
import com.example.shoppinglist.data.repositories.ShoppingRepository
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidCoreModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ShoppingApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidCoreModule(this@ShoppingApplication))
        bind() from singleton { ShoppingDataBase(instance()) }
        bind() from singleton { ShoppingRepository(instance()) }
        bind() from provider { ShoppingViewModelFactory(instance()) }
    }
}