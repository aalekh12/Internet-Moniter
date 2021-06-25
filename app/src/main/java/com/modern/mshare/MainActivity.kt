package com.modern.mshare

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.android.volley.RequestQueue

class MainActivity : AppCompatActivity() {
     lateinit var button:TextView
             var context=this
            var connectivity:ConnectivityManager?=null
           var info:NetworkInfo? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.send)

        button.setOnClickListener{
            connectivity= context.getSystemService(Service.CONNECTIVITY_SERVICE ) as ConnectivityManager
            if (connectivity!=null) {
                info = connectivity!!.activeNetworkInfo

                if (info != null) {

                    if (info!!.state == NetworkInfo.State.CONNECTED) {
                        //itnernet is avilavle
                            showAlertDialog()
                        Toast.makeText(context, "CONNECTED", Toast.LENGTH_LONG).show()
                    }

                } else {
                    showAlertDialog2()
                    //internet is not avilavle
                    Toast.makeText(context, "NOT CONNECTED", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    private fun showAlertDialog() {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("SUCCESSFULLY CONNECTED")
        alertDialog.setMessage("Internet Connection Found")
        alertDialog.setPositiveButton(
            "Ok"
        ) { _, _ ->
        }
        alertDialog.setNegativeButton(
            "Cancel"
        ) { _, _ -> }
        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        alert.show()
    }
    private fun showAlertDialog2() {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("NOT SUCCESSFULLY CONNECTED")
        alertDialog.setMessage("Internet Connection Not Found")
        alertDialog.setPositiveButton(
            "Ok"
        ) { _, _ ->
        }
        alertDialog.setNegativeButton(
            "Cancel"
        ) { _, _ -> }
        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        alert.show()
    }


}