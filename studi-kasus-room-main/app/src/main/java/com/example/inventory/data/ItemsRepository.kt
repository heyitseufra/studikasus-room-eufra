/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository yang menyediakan fungsi untuk menambah, memperbarui, menghapus,
 * dan mengambil data [Item] dari sumber data tertentu.
 *
 * Mendefinisikan interface ItemsRepository sebagai abstraksi dengan fungsi-fungsi
 * yang digunakan untuk akses data Item.
 */
interface ItemsRepository {
    /**
     * Mengambil semua item dari sumber data yang diberikan.
     */
    fun getAllItemsStream(): Flow<List<Item>>

    /**
     * Mengambil item dari sumber data yang sesuai dengan [id] yang diberikan.
     */
    fun getItemStream(id: Int): Flow<Item?>

    /**
     * Menambahkan item ke dalam sumber data.
     */
    suspend fun insertItem(item: Item)

    /**
     * Menghapus item dari sumber data.
     */
    suspend fun deleteItem(item: Item)

    /**
     * Memperbarui item di dalam sumber data.
     */
    suspend fun updateItem(item: Item)
}
