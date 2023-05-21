package com.example.mymessenger.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymessenger.R
import com.example.mymessenger.databinding.FragmentPhoneNumberBinding

class PhoneNumberFragment : Fragment() {

    companion object {
        private const val TAG = "PhoneNumberFragment"
    }

    private var _binding: FragmentPhoneNumberBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhoneNumberBinding.inflate(layoutInflater)
        binding.apply {

            return root
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}