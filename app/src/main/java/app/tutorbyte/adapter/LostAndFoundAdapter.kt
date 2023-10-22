package app.tutorbyte.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import app.tutorbyte.lostandfound.FoundFragment
import app.tutorbyte.lostandfound.LostFragment

class LostAndFoundAdapter(
    activity:FragmentActivity
):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> LostFragment()
            else -> FoundFragment()
        }


    }
}