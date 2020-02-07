package com.example.rental.cloud

import com.google.firebase.firestore.FirebaseFirestore

class Fire {

    object Static {

        lateinit var firebaseFirestore: FirebaseFirestore

        fun initializeCloud() {
            firebaseFirestore = FirebaseFirestore.getInstance()
        }

    }



}