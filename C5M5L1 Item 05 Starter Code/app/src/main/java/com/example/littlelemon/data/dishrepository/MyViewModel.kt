package com.example.littlelemon.data.dishrepository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(application: Application) : AndroidViewModel(application) {
    private val database: com.example.littlelemon.data.dishrepository.AppDatabase

    init {
        database = Room.databaseBuilder(
            application,
            com.example.littlelemon.data.dishrepository.AppDatabase::class.java,
            "database"
        ).build()
    }

    fun getAllDatabaseMenuItems(): LiveData<List<com.example.littlelemon.data.dishrepository.MenuItemRoom>> {
        return database.menuItemDao().getAll()
    }

    fun fetchMenuDataIfNeeded() {
        viewModelScope.launch(Dispatchers.IO) {
            if (database.menuItemDao().isEmpty()) {
                com.example.littlelemon.helpers.saveMenuToDatabase(
                    database,
                    com.example.littlelemon.helpers.fetchMenu("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
                )
            }
        }
    }
}
