package com.dm.sample.navigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.dm.sample.navigation.entity.Notification
import kotlinx.android.synthetic.main.fragment_notification_list.*
import java.text.SimpleDateFormat
import java.util.*


class NotificationListFragment : Fragment() {

    private val firstNotification =
        Notification("300", "Test User 1", "First notification message", Date())
    private val secondNotification =
        Notification("301", "Test User 2", "Second notification message", Date())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notification_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

        firstNotificationFrom.text = firstNotification.from
        firstNotificationMessage.text = firstNotification.message
        firstNotificationDate.text = formatter.format(firstNotification.date)

        secondNotificationFrom.text = secondNotification.from
        secondNotificationMessage.text = secondNotification.message
        secondNotificationDate.text = formatter.format(secondNotification.date)

        firstNotificationCardView.setOnClickListener { showNotificationDetails(firstNotification) }
        secondNotificationCardView.setOnClickListener { showNotificationDetails(secondNotification) }
    }

    private fun showNotificationDetails(notification: Notification) {
        val action = NotificationListFragmentDirections
            .actionNotificationListFragmentToNotificationDetailsFragment(notification)
        view?.findNavController()?.navigate(action)
    }
}
