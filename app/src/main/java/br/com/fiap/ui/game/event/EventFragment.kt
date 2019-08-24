package br.com.fiap.ui.game.event


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.localbroadcastmanager.content.LocalBroadcastManager

import br.com.fiap.R
import br.com.fiap.ui.game.hometeam.HomeTeamFragment
import kotlinx.android.synthetic.main.fragment_event.*

class EventFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btNextStep.setOnClickListener {
            nextScreen()
        }
    }

    private fun nextScreen() {
        sendEventName()
        val ft = activity?.supportFragmentManager?.beginTransaction()
        ft?.setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.enter_from_left,
            R.anim.exit_to_right
        )

        ft?.replace(R.id.containerGame, HomeTeamFragment())
        ft?.addToBackStack(null)
        ft?.commit()
    }

    private fun sendEventName() {
        val intent = Intent("FILTER_EVENT")
        intent.putExtra("event_name", inputEvent.text.toString())
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }

}
