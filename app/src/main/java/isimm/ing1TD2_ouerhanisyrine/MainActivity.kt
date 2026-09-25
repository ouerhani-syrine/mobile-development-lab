package isimm.ing1TD2_ouerhanisyrine

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import isimm.ing1TD2_ouerhanisyrine.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"This App is developped by syrine", Toast.LENGTH_LONG).show()
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val updateButton = findViewById<Button>(R.id.updateButton)
        val dateTextView = findViewById<TextView>(R.id.dateTextView)
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            if(password == "pw"+username){
                Toast.makeText(this,getString(R.string.msg_success), Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,getString(R.string.msg_error), Toast.LENGTH_SHORT).show()
            }
        }
        updateButton.setOnClickListener {
            dateTextView.text = Date().toString()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
     */
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            if(binding.etPassword.text.toString() == "pw"+binding.etUsername.text.toString()){
                Toast.makeText(this,R.string.msg_success, Toast.LENGTH_SHORT).show()
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,R.string.msg_error, Toast.LENGTH_SHORT).show()
            }
        }
        binding.updateButton.setOnClickListener {
            binding.dateTextView.text = Date().toString()
        }
    }
}