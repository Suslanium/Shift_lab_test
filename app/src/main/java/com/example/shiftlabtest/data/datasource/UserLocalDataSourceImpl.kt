package com.example.shiftlabtest.data.datasource

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.shiftlabtest.data.Constants
import com.example.shiftlabtest.domain.entity.registration.RegistrationRequest
import com.example.shiftlabtest.domain.entity.user.User
import java.time.LocalDate

class UserLocalDataSourceImpl(context: Context) : UserDataSource {

    private val masterKeyAlias =
        MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        Constants.USER_STORAGE_FILENAME,
        masterKeyAlias,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    override suspend fun getUser(): User? {
        val name = sharedPreferences.getString(Constants.NAME_ALIAS, null)
        val surname = sharedPreferences.getString(Constants.SURNAME_ALIAS, null)
        val birthDate = sharedPreferences.getString(Constants.BIRTHDATE_ALIAS, null)

        if (name == null || surname == null || birthDate == null) {
            return null
        }

        return User(
            name, surname, LocalDate.parse(birthDate)
        )
    }

    override suspend fun saveUser(userInfo: RegistrationRequest) {
        sharedPreferences.edit().putString(Constants.NAME_ALIAS, userInfo.name)
            .putString(Constants.SURNAME_ALIAS, userInfo.surname)
            .putString(Constants.BIRTHDATE_ALIAS, userInfo.birthDate.toString())
            .putString(Constants.PASSWORD_ALIAS, userInfo.password).apply()
    }
}