package com.cacttus.navigationdrawergr_2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cacttus.navigationdrawergr_2.adapters.UserAdapter
import com.cacttus.navigationdrawergr_2.databinding.UserFragmentBinding
import com.cacttus.navigationdrawergr_2.viewModel.UserViewModel

class UserFragment : Fragment() {
    private lateinit var binding: UserFragmentBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        viewModel.getUsers()
        observe()
    }

    fun observe() {
        viewModel.userList.observe(viewLifecycleOwner) { users ->
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerView.adapter = UserAdapter(users)
        }

        viewModel.loading.observe(viewLifecycleOwner) { loading ->

            if (loading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }
    }
}