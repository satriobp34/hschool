package schoolid.hustle.com.hustleschool

import android.app.ActivityManager
import android.app.Dialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.DialogTitle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import schoolid.hustle.com.hustleschool.R.anim.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnlogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            NavigasiAwal()
        }

        val atg = AnimationUtils.loadAnimation(this, R.anim.atg)
        val atgtwo = AnimationUtils.loadAnimation(this, R.anim.atgtwo)

        val pagetitle: TextView = findViewById<TextView>(R.id.pagetitle)
        val imageView3: ImageView = findViewById<ImageView>(R.id.imageView3)
        val pagesubtitle: TextView = findViewById<TextView>(R.id.pagesubtitle)

        ButtonQRScanner.setOnClickListener{
            NavigasiQR()
        }

        BtnDatabase.setOnClickListener{
            NavigasiData()
        }

        ButtonSite.setOnClickListener{
            NavigasiSite()
        }

        imageView3.startAnimation(atg)

        pagetitle.startAnimation(atgtwo)
        pagesubtitle.startAnimation(atgtwo)



    }



    private fun NavigasiQR(){
        val intent = Intent (this,QRScanner::class.java)
        startActivity(intent)
    }

    private fun NavigasiSite(){
        val intent = Intent (this,webviewSite::class.java)
        startActivity(intent)
    }

    private fun NavigasiData(){
        val intent = Intent (this,webviewDatabase::class.java)
        startActivity(intent)
    }

    private fun NavigasiAwal(){
        val intent = Intent (this,FirstInterface::class.java)
        intent.putExtra("finish",true)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        startActivity(intent)
        finish()
    }

    private fun jebulDialog(title: String){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        

    }






}
