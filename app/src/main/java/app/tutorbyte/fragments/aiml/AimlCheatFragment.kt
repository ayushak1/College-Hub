package app.tutorbyte.fragments.aiml

import android.annotation.SuppressLint
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import app.tutorbyte.helper.NetworkChangeReceiver
import app.tutorbyte.R
import app.tutorbyte.helper.Constants

class AimlCheatFragment : Fragment() {

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebViewWithUrl(webView: WebView?, url: String) {
        webView?.let {
            it.settings.javaScriptEnabled = true
            it.settings.loadWithOverviewMode = true
            it.settings.useWideViewPort = true

            it.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    return false
                }
            }

            it.webChromeClient = object : WebChromeClient() {}

            val htmlContent = Constants.getPDFHtml(url)
            it.loadData(htmlContent, "text/html", "utf-8")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_aiml_cheat, container, false)

        val ds1 = view.findViewById<Button>(R.id.ds)
        val ds2 = view.findViewById<Button>(R.id.ds2)
        val ds3 = view.findViewById<Button>(R.id.ds3)
        val ds4 = view.findViewById<Button>(R.id.ds4)

        val webView = view?.findViewById<WebView>(R.id.webView)

        val url = "https://drive.google.com/file/d/1G0g4vFpYWav6Fn4aLXdAbUvKz-b0y_m4/preview"
        setupWebViewWithUrl(webView, url)
        ds1.setOnClickListener {

            val pdfUrl = "https://drive.google.com/file/d/1G0g4vFpYWav6Fn4aLXdAbUvKz-b0y_m4/preview"
            setupWebViewWithUrl(webView, pdfUrl)
        }
        ds2.setOnClickListener {
            val pdfUrl = "https://drive.google.com/file/d/1ThhIH4ulRAvqiG7Ipr-TFgAp-zuOxoOW/preview"
            setupWebViewWithUrl(webView, pdfUrl)
        }

        ds3.setOnClickListener {
            val pdfUrl = "https://drive.google.com/file/d/16nXz0PhFbLtRuYVhqgLsnClKC5Tt1Bli/preview"
            setupWebViewWithUrl(webView, pdfUrl)
        }
        ds4.setOnClickListener {

            val pdfUrl = "https://drive.google.com/file/d/1F9cT0F01h50NCWVP9nPyfKagKMgZt0gR/preview"
            setupWebViewWithUrl(webView, pdfUrl)
        }


        val networkChangeReceiver = webView?.let { NetworkChangeReceiver(it) }
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        requireContext().registerReceiver(networkChangeReceiver, filter)


        return view
    }
}