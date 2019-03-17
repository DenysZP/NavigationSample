package com.dm.sample.navigation


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_notification_details.*
import java.text.SimpleDateFormat
import java.util.*


class NotificationDetailsFragment : Fragment() {

    private val args: NotificationDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notification_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val notification = args.notification
        idValue.text = notification.id
        fromValue.text = notification.from
        messageValue.text = notification.message
        dateValue.text = formatter.format(notification.date)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }

}
