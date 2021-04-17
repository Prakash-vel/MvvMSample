package com.example.mvvmsample

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmsample.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.i("inteer", "main activity${Integer.toHexString(255)}")


        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val mainViewModel: MainViewModel =
            ViewModelProviders.of(this).get(MainViewModel::class.java)
//
        try {
            mainViewModel._code.observe(this, Observer { it: String? ->
                binding.textView.setBackgroundColor(Color.parseColor(mainViewModel._code.value));
                binding.textView.text="Color Me  ${mainViewModel._code.value}"
            })
        }catch(e:Exception){
            Log.i("inteer","error $e")
        }

        binding.redButton.setOnClickListener {

                mainViewModel.color("red")

        }
        binding.greenButton.setOnClickListener {

                mainViewModel.color("green")
        }
        binding.blueButton.setOnClickListener {

                mainViewModel.color("blue")
        }


    }

}