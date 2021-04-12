package tads.eaj.ufrn.segundaprovajoaogabriel.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import tads.eaj.ufrn.segundaprovajoaogabriel.R
import tads.eaj.ufrn.segundaprovajoaogabriel.databinding.FragmentCadastraBinding
import tads.eaj.ufrn.segundaprovajoaogabriel.viewmodel.CadastraViewModel

class CadastraFragment : Fragment() {
    lateinit var viewModel: CadastraViewModel
    lateinit var binding: FragmentCadastraBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(CadastraViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        binding.ConfirmaButton.setOnClickListener {
            viewModel.saveMovie()
            Navigation.findNavController(requireView()).navigate(CadastraFragmentDirections.actionCadastraFragmentToHomeFragment())
        }

        binding.CancelarButton.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(CadastraFragmentDirections.actionCadastraFragmentToHomeFragment())
        }
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }

}