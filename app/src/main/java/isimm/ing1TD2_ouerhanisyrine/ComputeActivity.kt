package isimm.ing1TD2_ouerhanisyrine

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import isimm.ing1TD2_ouerhanisyrine.databinding.ActivityComputeBinding
import kotlin.math.sqrt

class ComputeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComputeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityComputeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        fun updateVisibility (){
            binding.editVal2.visibility = if(binding.radioSum.isChecked)View.VISIBLE else View.GONE
        }
        updateVisibility()
        binding.radioGroup.setOnCheckedChangeListener { _, _ -> updateVisibility() }
        binding.calcBtn.setOnClickListener {
            val v1 = binding.editVal1.text.toString()
            if(v1.isBlank()){
                Toast.makeText(this,R.string.notEmpty1, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val val1 =v1.toIntOrNull()
            if(val1 == null){
                Toast.makeText(this,R.string.num1, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(binding.radioSum.isChecked){
                val v2 = binding.editVal2.text.toString()
                if(v2.isBlank()){
                    Toast.makeText(this,R.string.notEmpty2, Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                val val2 = v2.toIntOrNull()
                if(val2 == null){
                    Toast.makeText(this,R.string.num2, Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                binding.result.text = (val1 + val2).toString()
            }
            else
                binding.result.text = (sqrt(val1.toDouble())).toString()
        }
    }
}