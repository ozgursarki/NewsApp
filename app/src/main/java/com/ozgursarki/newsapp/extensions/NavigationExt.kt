package com.ozgursarki.newsapp.extensions

import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.ozgursarki.newsapp.ui.tab.BaseFragment

fun BaseFragment.navigate(action: NavDirections) {
    this.findNavController().navigate(action)
}