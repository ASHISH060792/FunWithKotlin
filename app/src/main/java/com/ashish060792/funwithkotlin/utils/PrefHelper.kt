
import android.annotation.SuppressLint
import android.preference.PreferenceManager
import com.ashish060792.funwithkotlin.App

/**
 * Created by Ashish on 9/11/2017.
 */
object PrefHelper {
    /**
     * @param key
     * ( the Key to used to retrieve this data later  )
     * @param value
     * ( any kind of primitive values  )
     *
     *
     * non can be null!!!
     */
    @SuppressLint("ApplySharedPref") operator fun <T> set(key: String, value: T?) {
        if (InputHelper.isEmpty(key)) {
            throw NullPointerException("Key must not be null! (key = $key), (value = $value)")
        }
        val edit = PreferenceManager.getDefaultSharedPreferences(App.instance).edit()
        if (InputHelper.isEmpty(value)) {
            clearKey(key)
            return
        }
        if (value is String) {
            edit.putString(key, value as String?)
        } else if (value is Int) {
            edit.putInt(key, (value as Int?)!!)
        } else if (value is Long) {
            edit.putLong(key, (value as Long?)!!)
        } else if (value is Boolean) {
            edit.putBoolean(key, (value as Boolean?)!!)
        } else if (value is Float) {
            edit.putFloat(key, (value as Float?)!!)
        } else {
            edit.putString(key, value!!.toString())
        }
        edit.commit()//apply on UI
    }

    fun getString(key: String): String? {
        return PreferenceManager.getDefaultSharedPreferences(App.instance).getString(key, null)
    }

    fun getBoolean(key: String): Boolean {
        return PreferenceManager.getDefaultSharedPreferences(App.instance).getBoolean(key, false)
    }

    fun getInt(key: String): Int {
        return PreferenceManager.getDefaultSharedPreferences(App.instance).getInt(key, 0)
    }

    fun getLong(key: String): Long {
        return PreferenceManager.getDefaultSharedPreferences(App.instance).getLong(key, 0)
    }

    fun getFloat(key: String): Float {
        return PreferenceManager.getDefaultSharedPreferences(App.instance).getFloat(key, 0f)
    }

    fun clearKey(key: String) {
        PreferenceManager.getDefaultSharedPreferences(App.instance).edit().remove(key).apply()
    }

    fun isExist(key: String): Boolean {
        return PreferenceManager.getDefaultSharedPreferences(App.instance).contains(key)
    }

    fun clearPrefs() {
        PreferenceManager.getDefaultSharedPreferences(App.instance).edit().clear().apply()
    }

    val all: Map<String, *>
        get() = PreferenceManager.getDefaultSharedPreferences(App.instance).all
}
