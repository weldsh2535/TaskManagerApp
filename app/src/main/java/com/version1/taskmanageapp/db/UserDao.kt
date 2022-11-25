package com.version1.taskmanageapp.db

import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM userinfo ORDER BY id DESC")
    fun getAllUserInfo():List<UserEntity>?

    @Insert
    fun insertUser(user:UserEntity?)

    @Delete
    fun deleteUser(user: UserEntity?)

    @Update
    fun updateUser(user: UserEntity?)
}