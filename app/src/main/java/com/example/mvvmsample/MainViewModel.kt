package com.example.mvvmsample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.StringBuilder

class MainViewModel():ViewModel() {

    private var red:Int=1
    private var green:Int=1
    private var blue :Int=1
   val _code=MutableLiveData<String?>()

    init{


        Log.i("inteer","red${red} green${green} blue${blue}")
    }
    //textView.setBackgroundColor(Color.parseColor("#FF018786"));
    // Log.i("inteer","${Integer.toHexString(255)}")
    fun generateCode(){
        val string: String ="#${hexCode(red)}${hexCode(green)}${hexCode(blue)}"

        Log.i("inteer","hello ${string}")
        _code.value=string.toString()
        Log.i("inteer","code ${_code.value}")
    }
    fun color(str: String){
        Log.i("inteer","red${red} green${green} blue${blue}")
        when(str){
            "red" -> red+=5
            "green" -> green+=5
            "blue" -> blue+=5
        }
        //Log.i("inteer","red${red} green${green} blue${blue"))

        generateCode()
    }
    fun hexCode(int: Int): String {
        var mynum:Int=255
        if(int <255){
            mynum=int
        }
        var string=Integer.toHexString(mynum)
        if(string.length<2){
            string="0$string"
        }
        return string

    }
}