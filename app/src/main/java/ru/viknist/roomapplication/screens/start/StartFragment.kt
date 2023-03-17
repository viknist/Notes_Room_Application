package ru.viknist.roomapplication.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.viknist.roomapplication.APP
import ru.viknist.roomapplication.R
import ru.viknist.roomapplication.adapter.NoteAdapter
import ru.viknist.roomapplication.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.rvNotes
        adapter = NoteAdapter(emptyList()) { position ->
            val bundle = Bundle()
            bundle.putSerializable("note", adapter.noteList[position])
            APP.navController.navigate(R.id.action_startFragment_to_detailFragment, bundle)
        }
        recyclerView.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNotes ->
            adapter.setList(listNotes.asReversed())
        }

        binding.btnAddNote.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)
        }

    }

}