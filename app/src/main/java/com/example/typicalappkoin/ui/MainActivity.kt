package com.example.typicalappkoin.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.typicalappkoin.di.appModule
import com.example.typicalappkoin.ui.viewmodel.PostViewModel
import com.example.typicalappkoin.R
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    private val viewModel: PostViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        startKoin {
            androidContext(this@MainActivity)
            modules(appModule)
        }

        viewModel.fetchPosts()
        viewModel.posts.observe(this) { post ->
            Log.d("MainActivity", "onCreate: $post")
        }
    }
}