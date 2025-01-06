package com.cacttus.navigationdrawergr_2.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cacttus.navigationdrawergr_2.R
import com.cacttus.navigationdrawergr_2.adapters.PostAdapter
import com.cacttus.navigationdrawergr_2.databinding.PostFragmentBinding
import com.cacttus.navigationdrawergr_2.helpers.Helpers.addIntToSharedPreferences
import com.cacttus.navigationdrawergr_2.helpers.Helpers.provideRetrofit
import com.cacttus.navigationdrawergr_2.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostFragment : Fragment() {
    private lateinit var binding: PostFragmentBinding
    private var list: List<Post> = listOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PostFragmentBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGetPosts.setOnClickListener {
            Log.d("TAG", "onViewCreated:  button clicked ")
            getPosts()
        }
    }

    fun getPosts() {
        provideRetrofit().getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d("TAG", "onResponse: $response")
                    list = response.body()!!
                    var adapter = PostAdapter(requireContext(), list)
                    binding.postList.adapter = adapter

                    binding.postList.setOnItemClickListener { adapterView, view, i, l ->
                        addIntToSharedPreferences(requireContext(), "id", list[i].id)
                        var nextFragment = PostDetailsFragment()
                        //nextFragment.arguments = setIdToBundle(list[i].id)
                        setCurrentFragment(nextFragment)
                    }
                } else {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun setCurrentFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
        }.commit()
    }

    fun setIdToBundle(id: Int): Bundle {
        var bundle = Bundle()
        bundle.putInt("id", id)

        return bundle
    }

}