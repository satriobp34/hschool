package schoolid.hustle.com.hustleschool

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_webview_qr.*
import kotlinx.android.synthetic.main.activity_webview_site.*

class webviewQR : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview_qr)


        val progressBar = findViewById<ProgressBar>(R.id.progresbarqr)
        val url: String = intent.getStringExtra("url")

        progressBar.max=100
        progressBar.progress=1


        webview.webViewClient = object : WebViewClient() {


            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBar.visibility = View.VISIBLE
                bgputihqr.visibility = View.VISIBLE
                progressBar.progress = 1
            }


            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
                bgputihqr.visibility= View.GONE
                progressBar.progress = 100

            }

        }
        webview.settings.javaScriptEnabled = true
        webview.loadUrl(url)


    }




}
