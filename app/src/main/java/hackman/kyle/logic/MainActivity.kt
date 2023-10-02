package hackman.kyle.logic

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import hackman.kyle.khfirstapp.R
import hackman.kyle.khfirstapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_start)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        bindStartButton()
    }

    /**
    override fun onStart() {
    super.onStart()
    }

    override fun onResume() {
    super.onResume()
    }

    override fun onPause() {
    super.onPause()
    }

    override fun onStop() {
    super.onStop()
    }

    override fun onDestroy() {
    super.onDestroy()
    }

     **/

    private fun bindStartButton() {
        binding.start.setOnClickListener {
            navigateToGame()
        }
    }

    private fun navigateToGame() {
        supportFragmentManager.commit {
            add(R.id.fragment_start, PlayGameFragment())
        }
    }
}
