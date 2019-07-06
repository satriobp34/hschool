package schoolid.hustle.com.hustleschool

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.RenderProcessGoneDetail
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_webview_site.*

class webviewSite : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview_site)

        val progressBar = findViewById<ProgressBar>(R.id.progresbarsite)
        val url = "http://www.full-tekno.com"
        progressBar.max=100
        progressBar.progress=1


        webviewSite.webViewClient = object : WebViewClient() {


            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBar.visibility = View.VISIBLE
                bgputihside.visibility = View.VISIBLE
                progressBar.progress = 1
            }


            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
                bgputihside.visibility= View.GONE
                progressBar.progress = 100

            }

        }
        webviewSite.settings.javaScriptEnabled = true
                webviewSite.loadUrl(url)


    }

}