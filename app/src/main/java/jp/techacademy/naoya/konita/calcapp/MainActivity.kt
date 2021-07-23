package jp.techacademy.naoya.konita.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add.setOnClickListener(this)
        button_sub.setOnClickListener(this)
        button_multi.setOnClickListener(this)
        button_div.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var cal_result = 0.0
        var cal_flag = true //もっとスマートな方法があるのか？

        Log.d("DEBUG",input1.text.toString())
        if((input1.text.toString() == "") || (input2.text.toString() == "")){
            text_note.text = "数値を入力してください"
        } else {
            val num1 = input1.text.toString().toDouble()
            val num2 = input2.text.toString().toDouble()

            when (v.id) {
                R.id.button_add -> {
                    cal_result = num1 + num2
                }
                R.id.button_sub -> {
                    cal_result = num1 - num2
                }
                R.id.button_multi -> {
                    cal_result = num1 * num2
                }
                R.id.button_div -> {
                    if (num2 == 0.0) {
                        text_note.text = "2つめの数字が0なので計算できません！"
                        cal_flag = false //もっとスマートな方法があるのか？
                    } else {
                        cal_result = num1 / num2 //num2が0の場合は警告を出す
                    }
                }
            }

            if (cal_flag) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("VALUE", cal_result)
                startActivity(intent)
            }
        }
    }
}