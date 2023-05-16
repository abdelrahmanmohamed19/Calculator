package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.DecimalFormat


// Your code here


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
}

    fun onClickButton(v : View)
    {
        val text = (v as Button).text.toString()
        val oldinput = binding.input.text.toString()
        val newinput = oldinput+text
        binding.input.text = newinput
    }

    fun clear (v : View)
    {
        binding.input.text=""
        binding.finalResult.text =""
    }

    fun Delete (v : View)
    {
        val Length = binding.input.length()
        if(Length > 0)
        {
            binding.input.text = binding.input.text.subSequence(0,Length - 1)
        }
    }

   fun Result (v : View)
   {
       val expression = binding.input.text.toString()
       val result = ExpressionBuilder(expression).build().evaluate()
       binding.finalResult.text = DecimalFormat("#.##").format(result).toString()
   }
}
