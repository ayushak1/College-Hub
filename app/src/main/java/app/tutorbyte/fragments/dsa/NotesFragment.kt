package app.tutorbyte.fragments.dsa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import app.tutorbyte.R
import soup.neumorphism.NeumorphCardView


class NotesFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notes, container, false)
        val cd1 = view.findViewById<NeumorphCardView>(R.id.cardView1)
        val cd2 = view.findViewById<NeumorphCardView>(R.id.cardView2)
        cd1.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_striverFragment)
        }
        cd2.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_otherFragment)
        }
        return view
    }


}