package com.fajar.tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingActivity : AppCompatActivity() {

    private val pref by lazy { Preference(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        supportActionBar!!.title = "Setting"

        val switchMode = findViewById<SwitchMaterial>(R.id.switch_mode)

        switchMode.setOnCheckedChangeListener { _, isChecked ->
            when (isChecked) {
                true -> {
                    pref.put("dark_mode", true)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                false -> {
                    pref.put("dark_mode", false)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
        }

        switchMode.isChecked = pref.getBoolean("dark_mode")
    }
}