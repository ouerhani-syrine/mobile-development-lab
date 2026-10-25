package isimm.ing1TD2_ouerhanisyrine

import android.annotation.SuppressLint
import android.content.Intent
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
    @SuppressLint("ResourceAsColor")
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
            binding.bt1.setBackgroundColor(getColor(R.color.btn_inactive))
            binding.bt2.setBackgroundColor(getColor(R.color.primaryColor))
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
            //binding.resultat.text = a+" DT = "+ (an/3.40f).toString()+" €"
            val intent = Intent(this, ConversionActivity::class.java)
            intent.putExtra("montant",an)
            intent.putExtra("type","DT_TO_EURO")
            startActivity(intent)
        }
        binding.bt2.setOnClickListener {
            binding.bt2.setBackgroundColor(getColor(R.color.btn_inactive))
            binding.bt1.setBackgroundColor(getColor(R.color.primaryColor))
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
            //binding.resultat.text = a+" € = "+ (an*3.40f).toString()+" DT"
            val intent = Intent(this, ConversionActivity::class.java)
            intent.putExtra("montant",an)
            intent.putExtra("type","EURO_TO_DT")
            startActivity(intent)
        }
    }
}