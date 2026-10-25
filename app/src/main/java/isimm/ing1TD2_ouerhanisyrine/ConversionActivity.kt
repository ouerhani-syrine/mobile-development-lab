package isimm.ing1TD2_ouerhanisyrine

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import isimm.ing1TD2_ouerhanisyrine.databinding.ActivityConversionBinding

class ConversionActivity : AppCompatActivity() {
    lateinit var binding: ActivityConversionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityConversionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val montant = intent.getFloatExtra("montant",0.0f)
        val typeConv = intent.getStringExtra("type")
        if(typeConv == "DT_TO_EURO"){
            binding.resText.text = getString(R.string.conversion_result_dt_to_euro,montant,montant/3.40f)
        }else {
            binding.resText.text = getString(R.string.conversion_result_euro_to_dt,montant,montant*3.40f)
        }
    }
}