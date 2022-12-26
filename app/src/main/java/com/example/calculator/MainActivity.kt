package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_one.setOnClickListener{setTextFields("1")}
        btn_two.setOnClickListener{setTextFields("2")}
        btn_three.setOnClickListener{setTextFields("3")}
        btn_four.setOnClickListener{setTextFields("4")}
        btn_five.setOnClickListener{setTextFields("5")}
        btn_six.setOnClickListener{setTextFields("6")}
        btn_seven.setOnClickListener{setTextFields("7")}
        btn_eight.setOnClickListener{setTextFields("8")}
        btn_nine.setOnClickListener{setTextFields("9")}
        btn_zero.setOnClickListener{setTextFields("0")}
        btn_minus.setOnClickListener{setTextFields("-")}
        btn_plus.setOnClickListener{setTextFields("+")}
        btn_divide.setOnClickListener{setTextFields("/")}
        btn_multiply.setOnClickListener{setTextFields("*")}
        btn_OpenBracket.setOnClickListener{setTextFields("(")}
        btn_CloseBracket.setOnClickListener{setTextFields(")")}
        btn_point.setOnClickListener{setTextFields(".")}
        btn_clear.setOnClickListener{
            math_operation.text = ""
            result.text = ""
        }

        btn_back.setOnClickListener{
            val str = math_operation.text.toString()
            if(str.isNotEmpty())
                math_operation.text = str.substring(0, str.length - 1)
            result.text = ""
        }

        btn_equal.setOnClickListener{
            try{
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val output = ex.evaluate()

                val longRes = output.toLong()

                if(output == longRes.toDouble())
                    result.text = longRes.toString()
                else
                    result.text = output.toString()
            } catch (e:Exception){
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }
    fun setTextFields(str: String){
        math_operation.append(str)
    }
}