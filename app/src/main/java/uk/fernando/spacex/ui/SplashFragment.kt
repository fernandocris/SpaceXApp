package uk.fernando.spacex.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import uk.fernando.spacex.databinding.FragmentSplashBinding
import uk.fernando.spacex.extension.safeNav
import javax.inject.Inject


class SplashFragment @Inject constructor() : DaggerFragment() {

    private lateinit var binding: FragmentSplashBinding

    // View initialization logic
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // View binding
        binding = FragmentSplashBinding.inflate(layoutInflater)

        // End of animation, send user to MainActivity
        binding.motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                navToRocketList()
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {}

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {}

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}
        })


        return binding.root
    }

    private fun navToRocketList() {
        findNavController().safeNav(SplashFragmentDirections.navigateToRocketList())
    }

}