package hackman.kyle.app

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import hackman.kyle.khfirstapp.R
import hackman.kyle.khfirstapp.databinding.ActivityMainBinding
import hackman.kyle.logic.NavigationViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        observeScreenState()
    }

    private fun observeScreenState() {
        NavigationViewModel.screenState.addObserver {
            //  Log.e("zzz", "screen $it")
            val fragmentNavigateTo = when (it) {
                NavigationViewModel.Screen.START -> StartFragment()
                NavigationViewModel.Screen.PLAY_GAME -> PlayGameFragment()
                NavigationViewModel.Screen.RECAP -> RecapFragment()
            }
            supportFragmentManager.commit {
                if (it != NavigationViewModel.Screen.RECAP) {
                    replace(R.id.activityMain, fragmentNavigateTo)
                } else add(R.id.activityMain, fragmentNavigateTo)
            }
        }
    }

    override fun onDestroy() {
        NavigationViewModel.screenState.removeAllObservers()
        super.onDestroy()
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

    @Deprecated("Deprecated in Java")
    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        if (NavigationViewModel.shouldOverrideBackPressed()) {
            NavigationViewModel.onBackPressed()
        } else {
            super.onBackPressed()
        }
    }
}
