package com.mobapptuts.kotlinfragmentsharing

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log

class MainActivity : AppCompatActivity(), VideoIntentFragment.OnFragmentVideoUriListener {

    private val TAG = MainActivity::class.qualifiedName

    override fun onFragmentVideoUri(uri: Uri?) {
        Log.d(TAG, "video uri: $uri")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoIntentFragment = VideoIntentFragment.newInstance()
        replaceFragment(videoIntentFragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
