package com.example.androidprhome.data.authitems

import com.example.androidprhome.data.sharedprefences.SharedPreferencesHelper
import com.example.androidprhome.domain.auth.AuthRepository
import com.example.androidprhome.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
): AuthRepository {
    override suspend fun loginUser(userName: String, userPassword: String) {
        sharedPreferencesHelper.saveUserName(userName)
        sharedPreferencesHelper.saveUserPassword(userPassword)
    }

    override suspend fun showUserCreds(): UserModel {
        return withContext(Dispatchers.IO) {
            sharedPreferencesHelper.getUserCreds()
        }
    }

    override suspend fun doesUserExist(): Boolean {
        return withContext(Dispatchers.IO) {
            sharedPreferencesHelper.checkUserExists()
        }
    }

    override suspend fun userLogout() {
        withContext(Dispatchers.IO) {
            sharedPreferencesHelper.removeUser()
        }
    }


}