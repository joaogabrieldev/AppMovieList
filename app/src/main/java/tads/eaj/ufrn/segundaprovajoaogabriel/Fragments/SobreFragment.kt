package tads.eaj.ufrn.segundaprovajoaogabriel.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tads.eaj.ufrn.segundaprovajoaogabriel.R

class SobreFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sobre, container, false)
    }
}