package com.example.otpfield

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener, View.OnKeyListener , View.OnTouchListener{



    private lateinit var otpStr: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_otp_1.transformationMethod = PasswordTransformationMethod.getInstance()
        et_otp_2.transformationMethod = PasswordTransformationMethod.getInstance()
        et_otp_3.transformationMethod = PasswordTransformationMethod.getInstance()
        et_otp_4.transformationMethod = PasswordTransformationMethod.getInstance()
        et_otp_5.transformationMethod = PasswordTransformationMethod.getInstance()
        et_otp_6.transformationMethod = PasswordTransformationMethod.getInstance()
        setListeners()
    }
    private fun setListeners() {

        et_otp_1.setOnClickListener(this)
        et_otp_2.setOnClickListener(this)
        et_otp_3.setOnClickListener(this)
        et_otp_4.setOnClickListener(this)

        if (et_otp_5.visibility == View.VISIBLE) {
            et_otp_5.setOnClickListener(this)
            et_otp_6.setOnClickListener(this)

            et_otp_5.setOnKeyListener(this)
            et_otp_6.setOnKeyListener(this)

            et_otp_5.isEnabled = false
            et_otp_6.isEnabled = false

            et_otp_5.setOnTouchListener(this)
            et_otp_6.setOnTouchListener(this)

            et_otp_5.setOnEditorActionListener(TextView.OnEditorActionListener {_, actionId,_ ->
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    if (otpStr.length > 4) {
                        et_otp_6.isEnabled = true
                        et_otp_6.requestFocus()
                    }
                    return@OnEditorActionListener true
                }
                false
            })

            et_otp_6.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (otpStr.length > 5) {
                        et_otp_6.clearFocus()
                    }
                    return@OnEditorActionListener true
                }
                false
            })

            et_otp_5.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable) {
                    if (s.length == 1) {
                        et_otp_6.isEnabled = true
                        et_otp_6.requestFocus()
                        otpStr += s.toString()
                    }
                }
            })

            et_otp_6.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable) {
                    if (s.length == 1) {
                        et_otp_6.clearFocus()

                        otp_layout.requestFocus()
                        otpStr += s.toString()
                    }
                }
            })
        }

        et_otp_1.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                if (otpStr.isNotEmpty()) {
                    et_otp_2.isEnabled = true
                    et_otp_2.requestFocus()
                }
                return@OnEditorActionListener true
            }
            false
        })

        et_otp_2.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                if (otpStr.length > 1) {
                    et_otp_3.isEnabled = true
                    et_otp_3.requestFocus()
                }
                return@OnEditorActionListener true
            }
            false
        })

        et_otp_3.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                if (otpStr.length > 2) {
                    et_otp_4.isEnabled = true
                    et_otp_4.requestFocus()
                }
                return@OnEditorActionListener true
            }
            false
        })

        et_otp_4.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                if (et_otp_5.visibility == View.VISIBLE) {
                    if (otpStr.length > 3) {
                        et_otp_5.isEnabled = true
                        et_otp_5.requestFocus()
                    }
                } else {
                    if (otpStr.length > 3) {
                        et_otp_4.clearFocus()
                    }
                }
                return@OnEditorActionListener true
            }
            false
        })

        et_otp_1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                if (s.length == 1) {
                    et_otp_2.isEnabled = true
                    et_otp_2.requestFocus()
                    otpStr = s.toString()
                }
            }
        })

        et_otp_2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (s.length == 1) {
                    et_otp_3.isEnabled = true
                    et_otp_3.isFocusable = true
                    et_otp_3.requestFocus()
                    otpStr += s.toString()

                }
            }
        })

        et_otp_3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (s.length == 1) {
                    et_otp_4.isEnabled = true
                    et_otp_4.isFocusable = true
                    et_otp_4.requestFocus()
                    otpStr += s.toString()
                }
            }
        })

        et_otp_4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (s.length == 1) {

                    if (et_otp_6.visibility == View.VISIBLE) {
                        et_otp_5.isEnabled = true
                        et_otp_5.isFocusable = true
                        et_otp_5.requestFocus()
                    } else {
                        et_otp_4.clearFocus()
                        et_otp_1.isCursorVisible = false
                    }

                    otpStr += s.toString()
                }
            }
        })

        et_otp_1.setOnKeyListener(this)
        et_otp_2.setOnKeyListener(this)
        et_otp_3.setOnKeyListener(this)
        et_otp_4.setOnKeyListener(this)

        et_otp_1.isEnabled = true
        et_otp_2.isEnabled = false
        et_otp_3.isEnabled = false
        et_otp_4.isEnabled = false

        et_otp_1.setOnTouchListener(this)
        et_otp_2.setOnTouchListener(this)
        et_otp_3.setOnTouchListener(this)
        et_otp_4.setOnTouchListener(this)

    }


    private fun clearAllFields() {
        et_otp_1.setText("")
        et_otp_2.setText("")
        et_otp_3.setText("")
        et_otp_4.setText("")

        et_otp_1.isEnabled = true
        et_otp_1.isCursorVisible = true
        et_otp_2.isEnabled = false
        et_otp_3.isEnabled = false
        et_otp_4.isEnabled = false

        if (et_otp_5.visibility == View.VISIBLE) {
            et_otp_6.setText("")
            et_otp_5.setText("")

            et_otp_3.isEnabled = false
            et_otp_4.isEnabled = false
        }

        otpStr = ""
    }
    override fun onClick(v: View?) {
        R.id.et_otp_1
        clearAllFields()
        R.id.et_otp_2
        clearAllFields()
        R.id.et_otp_3
        clearAllFields()
        R.id.et_otp_4
        clearAllFields()
        R.id.et_otp_5
        clearAllFields()
        R.id.et_otp_6
        clearAllFields()
    }
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {

        if (event.action == KeyEvent.ACTION_DOWN) {

            when (v.id) {
                R.id.et_otp_1 -> onBackKeyClicked(keyCode)
                R.id.et_otp_2 -> onBackKeyClicked(keyCode)
                R.id.et_otp_3 -> onBackKeyClicked(keyCode)
                R.id.et_otp_4 -> onBackKeyClicked(keyCode)
                R.id.et_otp_5 -> onBackKeyClicked(keyCode)
                R.id.et_otp_6 -> onBackKeyClicked(keyCode)
            }
        }

        return false
    }
    private fun onBackKeyClicked(keyCode: Int) {
        if (et_otp_5.visibility == View.VISIBLE) {
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                if (otpStr.length == 6) {
                    et_otp_6.setText("")
                    et_otp_6.requestFocus()
                }
                if (otpStr.length == 5) {
                    et_otp_5.setText("")
                    et_otp_5.requestFocus()
                    et_otp_6.isEnabled = false
                }
                when {
                    otpStr.length == 4 -> {
                        et_otp_4.setText("")
                        et_otp_4.requestFocus()
                        et_otp_5.isEnabled = false
                        et_otp_6.isEnabled = false
                    }
                    otpStr.length == 3 -> {
                        et_otp_3.setText("")
                        et_otp_4.isEnabled = false
                        et_otp_5.isEnabled = false
                        et_otp_6.isEnabled = false
                        et_otp_3.requestFocus()
                    }
                    otpStr.length == 2 -> {
                        et_otp_2.setText("")
                        et_otp_2.requestFocus()
                        et_otp_3.isEnabled = false
                        et_otp_4.isEnabled = false
                        et_otp_5.isEnabled = false
                        et_otp_6.isEnabled = false
                    }
                    otpStr.length == 1 -> {
                        et_otp_1.setText("")
                        et_otp_1.requestFocus()
                        et_otp_2.isEnabled = false
                        et_otp_3.isEnabled = false
                        et_otp_4.isEnabled = false
                        et_otp_5.isEnabled = false
                        et_otp_6.isEnabled = false
                    }
                }

                if (otpStr.isNotEmpty()) {
                    otpStr = otpStr.substring(0, otpStr.length - 1)
                }

            }
        } else {
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                when {
                    otpStr.length == 4 -> {
                        et_otp_4.setText("")
                        et_otp_4.requestFocus()
                    }
                    otpStr.length == 3 -> {
                        et_otp_3.setText("")
                        et_otp_4.isEnabled = false
                        et_otp_3.requestFocus()
                    }
                    otpStr.length == 2 -> {
                        et_otp_2.setText("")
                        et_otp_2.requestFocus()
                        et_otp_3.isEnabled = false
                        et_otp_4.isEnabled = false
                    }
                    otpStr.length == 1 -> {
                        et_otp_1.setText("")
                        et_otp_1.requestFocus()
                        et_otp_2.isEnabled = false
                        et_otp_3.isEnabled = false
                        et_otp_4.isEnabled = false
                    }
                }

                if (otpStr.isNotEmpty()) {
                    otpStr = otpStr.substring(0, otpStr.length - 1)
                }
            }
        }

    }
    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View, event: MotionEvent): Boolean {

        when (v.id) {
            R.id.et_otp_1 -> if (et_otp_1.text.toString() != "") {
                clearAllFields()
            }

            R.id.et_otp_2 -> if (et_otp_1.text.toString() != "") {
                clearAllFields()
            }

            R.id.et_otp_3 -> if (et_otp_1.text.toString() != "") {
                clearAllFields()
            }

            R.id.et_otp_4 -> if (et_otp_1.text.toString() != "") {
                clearAllFields()
            }

            R.id.et_otp_5 -> if (et_otp_1.text.toString() != "") {
                clearAllFields()
            }

            R.id.et_otp_6 -> if (et_otp_1.text.toString() != "") {
                clearAllFields()
            }
        }

        return false
    }


}
