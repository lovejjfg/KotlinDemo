package com.example.tt.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import com.example.tt.kotlindemo.R.id.fab
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.functions.Function
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import java.util.*

class Main2Activity : AppCompatActivity() {
    internal var listener: View.OnClickListener? = null
    var list: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val toolbar = findViewById(R.id.toolbar) as Toolbar

        setSupportActionBar(toolbar)
        setClickListener(View.OnClickListener { view ->
            //intent跳转
            val i = Intent(this@Main2Activity, Main4Activity::class.java)
            startActivity(i)
        })
        list = ArrayList<String>()
        list!!.add("1")
        list!!.add("2")
        list!!.add("3")
        list!!.add("4")
        //for循环
        for (i in list!!.asIterable()) {
            Log.i(i, i)
        }

        for (j in 0..6) {
            Log.e("j", "" + j)
        }

        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
        list.toObservable() // extension function for Iterables
                .filter { it.length >= 5 }
                .subscribeBy(  // named arguments for lambda Subscribers
                        onNext = { Log.e("tag", it) },
                        onError =  { it.printStackTrace() },
                        onComplete = { println("Done!") }
                )
        val tt: String = "xxxx"

        Observable.just(tt)
                .map { t: String? -> t!!.length }
                .subscribeBy(onNext = {},onError = { println(it)},onComplete ={ println()})


        //findViewById
        val fab = findViewById(R.id.fab) as FloatingActionButton
//        fab.setOnClickListener({ view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() })
        fab.setOnClickListener(listener)
    }

    fun setClickListener(listener: View.OnClickListener) {
        this.listener = listener
    }

    //swich
    fun swich(i: Int): String? {
        when (i) {
            0 -> return "1"
            1 -> return "2"
            2 -> return "3"
        }
        return null
    }

}
