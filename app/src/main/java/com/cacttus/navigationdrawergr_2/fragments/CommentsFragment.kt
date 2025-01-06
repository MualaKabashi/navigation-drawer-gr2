package com.cacttus.navigationdrawergr_2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cacttus.navigationdrawergr_2.databinding.CommentsFragmentBinding
import com.cacttus.navigationdrawergr_2.helpers.Helpers.provideRetrofit
import com.cacttus.navigationdrawergr_2.model.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsFragment : Fragment() {
    private lateinit var binding: CommentsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CommentsFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCommentByPostId()
    }

    fun getCommentByPostId() {
        binding.btnGetComments.setOnClickListener {
            if (!binding.userPostId.text.isNullOrEmpty() &&
                !binding.userPostId.text.isNullOrBlank()
            ) {
                var postId = binding.userPostId.text.trim().toString().toInt()

                provideRetrofit().getCommentsByPostId(postId)
                    .enqueue(object : Callback<List<Comment>> {
                        override fun onResponse(
                            call: Call<List<Comment>>,
                            response: Response<List<Comment>>
                        ) {
                            if (response.isSuccessful && response.body() != null) {
                                binding.data.text = response.body()!!.toString()
                            }
                        }

                        override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                            Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
                        }

                    })

            }


        }
    }


}