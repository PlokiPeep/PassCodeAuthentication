package com.example.passcodeauthentication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.passcodeauthentication.R
import android.content.Context
import android.widget.Toast
import android.content.Intent


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var view_01: View
    lateinit var view_02: View
    lateinit var view_03: View
    lateinit var view_04: View

    lateinit var btn_01: Button
    lateinit var btn_02: Button
    lateinit var btn_03: Button
    lateinit var btn_04: Button
    lateinit var btn_05: Button
    lateinit var btn_06: Button
    lateinit var btn_07: Button
    lateinit var btn_08: Button
    lateinit var btn_09: Button
    lateinit var btn_00: Button
    lateinit var btn_clear: Button

    var numbersList = ArrayList<String>()
    var passcode = ""
    lateinit var num_01: String
    lateinit var num_02: String
    lateinit var num_03: String
    lateinit var num_04: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeComponents();

    }

    private fun initializeComponents() {
        view_01 = findViewById(R.id.view_01)
        view_02 = findViewById(R.id.view_02)
        view_03 = findViewById(R.id.view_03)
        view_04 = findViewById(R.id.view_04)

        btn_01 = findViewById(R.id.btn_01)
        btn_02 = findViewById(R.id.btn_02)
        btn_03 = findViewById(R.id.btn_03)
        btn_04 = findViewById(R.id.btn_04)
        btn_05 = findViewById(R.id.btn_05)
        btn_06 = findViewById(R.id.btn_06)
        btn_07 = findViewById(R.id.btn_07)
        btn_08 = findViewById(R.id.btn_08)
        btn_09 = findViewById(R.id.btn_09)
        btn_00 = findViewById(R.id.btn_00)
        btn_clear = findViewById(R.id.btn_clear)

        btn_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_03.setOnClickListener(this);
        btn_04.setOnClickListener(this);
        btn_05.setOnClickListener(this);
        btn_06.setOnClickListener(this);
        btn_07.setOnClickListener(this);
        btn_08.setOnClickListener(this);
        btn_09.setOnClickListener(this);
        btn_00.setOnClickListener(this);
        btn_clear.setOnClickListener(this);

    }

    override fun onClick(view: View) {
        // Handle click events here
        when (view.id) {
            R.id.btn_01 -> {
                numbersList.add("1")
                passNumber(numbersList)
                return
            }
            R.id.btn_02 -> {
                numbersList.add("2")
                passNumber(numbersList)
                return
            }
            R.id.btn_03 -> {
                numbersList.add("3")
                passNumber(numbersList)
                return
            }
            R.id.btn_04 -> {
                numbersList.add("4")
                passNumber(numbersList)
                return
            }
            R.id.btn_05 -> {
                numbersList.add("5")
                passNumber(numbersList)
                return
            }
            R.id.btn_06 -> {
                numbersList.add("6")
                passNumber(numbersList)
                return
            }
            R.id.btn_07 -> {
                numbersList.add("7")
                passNumber(numbersList)
                return
            }
            R.id.btn_08 -> {
                numbersList.add("8")
                passNumber(numbersList)
                return
            }
            R.id.btn_09 -> {
                numbersList.add("9")
                passNumber(numbersList)
                return
            }
            R.id.btn_00 -> {
                numbersList.add("0")
                passNumber(numbersList)
                return
            }
            R.id.btn_clear -> {
                numbersList.clear()
                passNumber(numbersList)
                return
            }
            else -> {
                // Handle any other cases (if necessary)
            }
        }


    }
    private fun passNumber(numbersList: ArrayList<String>) {
        if (numbersList.isEmpty()) {
            view_01.setBackgroundResource(R.drawable.bg_view_grey_oval)
            view_02.setBackgroundResource(R.drawable.bg_view_grey_oval)
            view_03.setBackgroundResource(R.drawable.bg_view_grey_oval)
            view_04.setBackgroundResource(R.drawable.bg_view_grey_oval)
        } else {
            when (numbersList.size) {
                1 -> {
                    num_01 = numbersList.get(0)
                    view_01.setBackgroundResource(R.drawable.bg_view_blue_oval)
                }
                2 -> {
                    num_02 = numbersList.get(1)
                    view_02.setBackgroundResource(R.drawable.bg_view_blue_oval)
                }
                3 -> {
                    num_03 = numbersList.get(2)
                    view_03.setBackgroundResource(R.drawable.bg_view_blue_oval)
                }
                4 -> {
                    num_04 = numbersList.get(3)
                    view_04.setBackgroundResource(R.drawable.bg_view_blue_oval)
                    passcode = num_01 + num_02 + num_03 + num_04
                    if (getPassCode().length == 0) {
                        savePassCode(passcode)
                    } else {
                        matchPassCode()
                    }
                    return
                }

            }
        }
    }

    private fun matchPassCode() {
        if (getPassCode() == passcode) {
            startActivity(Intent(this, DashboardActivity::class.java))
        } else {
            Toast.makeText(this, "Passcode doesn't match, please try again!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun savePassCode(passCode: String): SharedPreferences.Editor {
        val preferences = getSharedPreferences("passcode_pref", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString("passcode", passCode)
        editor.apply()

        return editor
    }

    private fun getPassCode(): String {
        val preferences = getSharedPreferences("passcode_pref", Context.MODE_PRIVATE)
        return preferences.getString("passcode", "") ?: ""
    }
}


