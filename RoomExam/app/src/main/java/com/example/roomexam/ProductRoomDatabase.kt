package com.example.roomexam

import androidx.room.Database
import androidx.room.vo.Database


@Database(entities = [(Product::class)], version = 1)
abstract class ProductRoomDatabase: RoomDatabase() {
}