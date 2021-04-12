package tads.eaj.ufrn.segundaprovajoaogabriel.Fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import tads.eaj.ufrn.segundaprovajoaogabriel.Adapters.MovieAdapter
import tads.eaj.ufrn.segundaprovajoaogabriel.R
import tads.eaj.ufrn.segundaprovajoaogabriel.viewmodel.HomeViewModel
import tads.eaj.ufrn.segundaprovajoaogabriel.databinding.FragmentHomeBinding


@Suppress("DEPRECATION")
class HomeFragment : Fragment() {

    lateinit var homeViewModel : HomeViewModel
    lateinit var binding : FragmentHomeBinding
    var movieAdapter = MovieAdapter()


    override fun onCreateView(inflater:LayoutInflater,container:ViewGroup?,savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        homeViewModel.listMovies.observe(viewLifecycleOwner, {
            movieAdapter.movies = it
            movieAdapter.notifyDataSetChanged()
        })

        recyclerViewUp(movieAdapter)
        binding.recyclerviewhome.addOnItemTouchListener(RecyclerViewClickListener(requireContext(),binding.recyclerviewhome,
            object: RecyclerViewClickListener.OnItemClickListener{
                override fun onItemClick(view: View, position: Int) {
                    Navigation.findNavController(binding.recyclerviewhome).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(position+1))
                }
                override fun onItemLongClick(view: View, position: Int) {
                    Log.i("TEST","Entrou")
                    Navigation.findNavController(binding.recyclerviewhome).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(position))
                }

        }))
        setHasOptionsMenu(true)
        return binding.root
    }


    fun recyclerViewUp(adapter:MovieAdapter){
        binding.recyclerviewhome.adapter = adapter
        binding.recyclerviewhome.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
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