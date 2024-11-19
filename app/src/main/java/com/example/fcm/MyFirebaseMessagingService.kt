package com.example.fcm

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        // Handle the received message
        if (remoteMessage.data.isNotEmpty()) {
            Log.d("FCM", "Message data payload: " + remoteMessage.data)
        }

        if (remoteMessage.notification != null) {
            Log.d("FCM", "Message Notification Body: " + remoteMessage.notification?.body)
            // Show a notification or handle the data here
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FCM", "New token: $token")
        // Send the new token to your backend server to update the registration token.
    }
}