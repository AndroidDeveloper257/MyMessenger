package com.example.mymessenger.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mymessenger.database.entity.UserEntity
import com.example.mymessenger.databinding.FragmentPhoneNumberBinding
import com.example.mymessenger.networking.NetworkHelper
import com.example.mymessenger.vm.UserResource
import com.example.mymessenger.vm.UserViewModel
import com.example.mymessenger.vm.UserViewModelFactory
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class PhoneNumberFragment : Fragment() {

    companion object {
        private const val TAG = "PhoneNumberFragment"
    }

    private var _binding: FragmentPhoneNumberBinding? = null
    private val binding get() = _binding!!

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhoneNumberBinding.inflate(layoutInflater)
        binding.apply {
            var cnt = 0L
            firebaseDatabase = FirebaseDatabase.getInstance()
            reference = firebaseDatabase.getReference("users")
            continueBtn.setOnClickListener {
                reference
                    .child("$cnt")
                    .setValue(
                        UserEntity(
                            cnt++,
                            "Jasur",
                            "Alimov",
                            "987654321",
                            "url",
                            0,
                            false,
                            "sadasd"
                        )
                    )
            }

            userViewModel = ViewModelProvider(
                requireActivity(),
                UserViewModelFactory(
                    NetworkHelper(requireContext())
                )
            )[UserViewModel::class.java]
            userViewModel
                .getLiveData()
                .observe(viewLifecycleOwner
                ) { userResource ->
                    when (userResource) {
                        is UserResource.Error -> {
                            onError(userResource.e)
                        }
                        is UserResource.Loading -> {
                            onLoading()
                        }
                        is UserResource.Success -> {
                            onSuccess(userResource.userList)
                        }
                        null -> TODO()
                    }
                }

            return root
        }
    }

    private fun onError(e: Throwable) {
        Log.e(TAG, "onError: something went wrong ${e.message}")
        Log.e(TAG, "onError: something went wrong ${e.printStackTrace()}")
    }

    private fun onLoading() {
        Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onLoading: Loading")
    }

    private fun onSuccess(userList: List<UserEntity>) {
        Log.d(TAG, "onSuccess: ${userList.size} data found")
        userList.forEach {
            Log.d(TAG, "onSuccess: $it")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}