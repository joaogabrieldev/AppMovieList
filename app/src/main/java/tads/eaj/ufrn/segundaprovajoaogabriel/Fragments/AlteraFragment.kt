package tads.eaj.ufrn.segundaprovajoaogabriel.Fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import tads.eaj.ufrn.segundaprovajoaogabriel.R
import tads.eaj.ufrn.segundaprovajoaogabriel.databinding.FragmentAlteraBinding
import tads.eaj.ufrn.segundaprovajoaogabriel.viewmodel.AlteraViewModel

class AlteraFragment : Fragment() {
    private lateinit var viewModel: AlteraViewModel
    private lateinit var binding: FragmentAlteraBinding
    val args:AlteraFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(AlteraViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        binding.lifecycleOwner = this
        viewModel.setMovie(args.id)
        binding.viewmodel = viewModel

        binding.ConfirmaButton.setOnClickListener {
            viewModel.update()
            Navigation.findNavController(requireView()).navigate(AlteraFragmentDirections.actionAlteraFragmentToHomeFragment())
        }
        binding.CancelarButton.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(AlteraFragmentDirections.actionAlteraFragmentToHomeFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_options, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(requireView()))||
                super.onOptionsItemSelected(item)
    }

}