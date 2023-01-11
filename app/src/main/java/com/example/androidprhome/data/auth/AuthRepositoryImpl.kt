package com.example.androidprhome.data.auth

import com.example.androidprhome.data.sharedpreferences.SharedPreferencesHelper
import com.example.androidprhome.domain.auth.AuthRepository
import com.example.androidprhome.model.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
): AuthRepository {
    override suspend fun loginUser(userName: String, userPassword: String) {
        sharedPreferencesHelper.saveUserName(userName)
        sharedPreferencesHelper.saveUserPassword(userPassword)

    }

    override suspend fun showUserCreds(): UserModel {
        return sharedPreferencesHelper.getUserCreds()
    }

    override suspend fun doesUserExist(): Boolean {
        return sharedPreferencesHelper.checkUserExists()
    }

    override suspend fun userLogout() {
        sharedPreferencesHelper.removeUser()
    }
}