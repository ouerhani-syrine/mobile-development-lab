package isimm.ing1TD2_ouerhanisyrine

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import isimm.ing1TD2_ouerhanisyrine.databinding.ActivityCurrencyBinding
import java.util.zip.Inflater

class CurrencyActivity : AppCompatActivity() {
    lateinit var binding: ActivityCurrencyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCurrencyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.bt1.setOnClickListener {
            binding.bt1.setBackgroundColor(Color.DKGRAY)
            binding.bt2.setBackgroundColor(ContextCompat.getColor(this,R.color.primaryColor))
            var a = binding.edit1.text.toString()
            if(a.isBlank()){
                Toast.makeText(this,R.string.notEmpty, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            var an = a.toFloatOrNull()
            if(an == null){
                Toast.makeText(this,R.string.num1, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            binding.resultat.text = a+" DT = "+ (an/3.40f).toString()+" €"
        }
        binding.bt2.setOnClickListener {
            binding.bt2.setBackgroundColor(Color.DKGRAY)
            binding.bt1.setBackgroundColor(ContextCompat.getColor(this,R.color.primaryColor))
            var a = binding.edit1.text.toString()
            if(a.isBlank()){
                Toast.makeText(this,R.string.notEmpty, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            var an = a.toFloatOrNull()
            if(an == null){
                Toast.makeText(this,R.string.num1, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            binding.resultat.text = a+" DT = "+ (an*3.40f).toString()+" €"
        }
    }
}