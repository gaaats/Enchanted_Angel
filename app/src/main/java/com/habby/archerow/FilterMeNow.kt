package com.habby.archerow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.habby.archerow.gaaame.GameActivity

class FilterMeNow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_me_now)

        val sharPref = getSharedPreferences("SP", MODE_PRIVATE)
        val nameTest: String? = sharPref.getString(ApppppCL.C1, "null")
        val deepTest: String? = sharPref.getString(ApppppCL.D1, "null")
        if (nameTest!!.contains("tdb2")){
            Log.d("zero_filter", "nameWeb")
            Intent(this, Weeeeeb::class.java)
                .also { startActivity(it) }
            finish()
        }
        else if(deepTest!!.contains("tdb2")){
            Log.d("zero_filter", "deepWeb")
            Intent(this, Weeeeeb::class.java)
                .also { startActivity(it) }
            finish()
        }
        else{
            Log.d("zero_filter", "toGame")
            Intent(this, GameActivity::class.java)
                .also { startActivity(it) }
            finish()
        }

    }
}