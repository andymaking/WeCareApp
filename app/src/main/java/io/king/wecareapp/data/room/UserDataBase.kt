package io.king.wecareapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import io.king.wecareapp.data.responses.User

@Database(entities = [User::class], version = 1)
abstract  class UserDataBase : RoomDatabase(){

    abstract val dao : RoomDao


}