package com.afam.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.afam.todolist.databinding.FragmentInitBinding

class InitFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentInitBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentInitBinding.inflate(inflater, container, false)
        return binding.root
//        return inflater.inflate(R.layout.fragment_init, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingBtnNewItem.setOnClickListener {
            findNavController().navigate(R.id.action_initFragment_to_formNewItemFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}