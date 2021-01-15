package com.manish.softuserclone.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment

import com.manish.softuserclone.R

class AboutUsFragment : Fragment() {
    private lateinit var webviewSoftwarica: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_fragment_aboutus, container, false)
        webviewSoftwarica = view.findViewById(R.id.webviewSoftwarica)
        webviewSoftwarica.settings.javaScriptEnabled = true
        val webViewClient = WebViewClient()
        webviewSoftwarica.webViewClient = webViewClient
        webviewSoftwarica.loadUrl("https://softwarica.edu.np");
        return view
    }
}