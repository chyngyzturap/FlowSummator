package com.pharos.flowsummator.presentation.ui
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import android.widget.Toast
import com.pharos.flowsummator.databinding.ActivityMainBinding
import com.pharos.flowsummator.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            val input = binding.inputEditText.text.toString().toIntOrNull()
            if (input != null) {
                binding.resultTextView.text = ""
                viewModel.startFlowSummation(input)
            } else {
                Toast.makeText(this, "Неверное значение", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.flowResult.observe(this) { result ->
            binding.resultTextView.append("${result.value} ")
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putCharSequence(KEY_RESULT_TEXT, binding.resultTextView.text)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedResultText = savedInstanceState.getCharSequence(KEY_RESULT_TEXT)
        binding.resultTextView.text = savedResultText
    }

    companion object {
        private const val KEY_RESULT_TEXT = "result_text"
    }

}


