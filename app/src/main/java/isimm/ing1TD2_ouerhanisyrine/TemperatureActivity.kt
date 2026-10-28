package isimm.ing1TD2_ouerhanisyrine

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import isimm.ing1TD2_ouerhanisyrine.databinding.ActivityTemperatureBinding
import kotlin.math.roundToInt

class TemperatureActivity : AppCompatActivity() {
    lateinit var binding : ActivityTemperatureBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTemperatureBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        fun conv(){
            var t = binding.e1.text.toString()
            if(t.isBlank()){
                Toast.makeText(this,R.string.notEmpty, Toast.LENGTH_LONG).show()
                return;
            }
            var nt = t.toFloatOrNull()
            if(nt == null){
                Toast.makeText(this,R.string.num1, Toast.LENGTH_LONG).show()
                return;
            }
            if(binding.rgrp.checkedRadioButtonId == R.id.ctof){
                if(binding.arr.isChecked)
                    binding.res.text = ((9f/5f)*nt+32).roundToInt().toString()
                else
                    binding.res.text = ((9f/5f)*nt+32).toString()
            }
            else if(binding.rgrp.checkedRadioButtonId == R.id.ftoc){
                if(binding.arr.isChecked)
                    binding.res.text = ((5f/9f)*(nt-32)).roundToInt().toString()
                else
                    binding.res.text = ((5f/9f)*(nt-32)).toString()
            }
        }
        binding.rgrp.setOnCheckedChangeListener { group, i ->
            conv()
        }
        binding.arr.setOnCheckedChangeListener { button, bool ->
            conv()
        }


    }
}