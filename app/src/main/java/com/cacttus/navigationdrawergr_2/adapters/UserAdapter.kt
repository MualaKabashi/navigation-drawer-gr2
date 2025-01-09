package com.cacttus.navigationdrawergr_2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cacttus.navigationdrawergr_2.databinding.UserItemBinding
import com.cacttus.navigationdrawergr_2.model.User

class UserAdapter(var list: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(var binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindUser(user: User) {
            binding.user = user
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
        var binding = UserItemBinding.inflate(view, parent, false)

        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindUser(list[position])
    }
}