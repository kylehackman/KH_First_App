package hackman.kyle.app

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

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        navigateToStart()

    }

    private fun navigateToStart() {
        supportFragmentManager.commit {
            add(R.id.activityMain, StartFragment())
        }
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


}
