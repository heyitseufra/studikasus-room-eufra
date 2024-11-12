package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Kelas database dengan objek Instance tunggal.
 *
 * InventoryDatabase didefinisikan sebagai kelas abstrak yang memanfaatkan RoomDatabase,
 * dengan ItemDao sebagai antarmuka akses data untuk mengelola entitas Item. Kelas ini
 * menerapkan pola singleton untuk menjamin bahwa hanya ada satu instance database yang aktif.
 */
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase {
            // Jika Instance tidak null, kembalikan; jika tidak, buat instance database baru
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
