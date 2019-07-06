package schoolid.hustle.com.hustleschool

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_webview_database.*
import kotlinx.android.synthetic.main.activity_webview_site.*


class webviewDatabase : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview_database)

        val url = "https://bit.ly/2Fa7En2"
        val progressBar = findViewById<ProgressBar>(R.id.progresbardata)

        progressBar.max=100
        progressBar.progress=1


        webviewData.webViewClient = object : WebViewClient() {


            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBar.visibility = View.VISIBLE
                bgputihdata.visibility = View.VISIBLE
                progressBar.progress = 1
            }


            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
                bgputihdata.visibility= View.GONE
                progressBar.progress = 100

            }

        }
        webviewData.settings.javaScriptEnabled = true
        webviewData.loadUrl(url)


    }
}
