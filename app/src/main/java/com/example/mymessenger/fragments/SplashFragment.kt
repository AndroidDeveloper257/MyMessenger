package com.example.mymessenger.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.mymessenger.R
import com.example.mymessenger.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    companion object {
        private const val TAG = "SplashFragment"
    }

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    private lateinit var expandAnimation: Animation
    private lateinit var collapseAnimation: Animation

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(layoutInflater)
        binding.apply {
            expandAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.splash_expand_anim)
            collapseAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.splash_collapse_anim)
            startExpandAnimation()

            return root
        }
    }

    private fun startExpandAnimation() {
        binding.apply {
            circle.startAnimation(expandAnimation)
            expandAnimation.setAnimationListener(object : AnimationListener {
                override fun onAnimationStart(animation: Animation?) {

                }

                override fun onAnimationEnd(animation: Animation?) {
                    startCollapseAnimation()
                }

                override fun onAnimationRepeat(animation: Animation?) {

                }

            })
        }
    }

    private fun startCollapseAnimation() {
        binding.apply {
            circle.startAnimation(collapseAnimation)
            collapseAnimation.setAnimationListener(object : AnimationListener{
                override fun onAnimationStart(animation: Animation?) {

                }

                override fun onAnimationEnd(animation: Animation?) {
//                    startExpandAnimation()
                    findNavController().navigate(R.id.phoneNumberFragment)
                }

                override fun onAnimationRepeat(animation: Animation?) {

                }

            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}