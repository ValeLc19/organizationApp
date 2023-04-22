package com.example.organizationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.Navigation

class MenuPrincipalFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.menu_principal_fragment, container, false)
        view.findViewById<ImageButton>(R.id.food_button).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_menuPrincipalFragment_to_foodFragment)
        }
        view.findViewById<ImageButton>(R.id.task_button).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_menuPrincipalFragment_to_task_fragment)
        }
        view.findViewById<ImageButton>(R.id.clean_button).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_menuPrincipalFragment_to_clean_fragment)
        }
        view.findViewById<ImageButton>(R.id.fitness_button).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_menuPrincipalFragment_to_fitness_fragment)
        }
        view.findViewById<ImageButton>(R.id.finances_button).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_menuPrincipalFragment_to_finances_fragment)
        }
        view.findViewById<ImageButton>(R.id.places_button).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_menuPrincipalFragment_to_places_fragment)
        }
        return view
    }
}