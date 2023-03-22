
package com.learn.app
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.PyException
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		if (! Python.isStarted()) {
			Python.start(AndroidPlatform(this))
		}
		val py = Python.getInstance()
		val module = py.getModule("hello-world")
		val message = module.call("hello-world").toJava(String::class.java)
		val textView: TextView = findViewById(R.id.android_text) as TextView
		textView.text = message
	}
}
