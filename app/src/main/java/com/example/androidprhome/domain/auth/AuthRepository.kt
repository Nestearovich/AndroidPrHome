package com.example.androidprhome.domain.auth

import com.example.androidprhome.model.UserModel

interface AuthRepository {

   suspend fun loginUser(userName: String, userPassword: String)

   suspend fun showUserCreds(): UserModel

   suspend fun doesUserExist(): Boolean

   suspend fun userLogout()
}