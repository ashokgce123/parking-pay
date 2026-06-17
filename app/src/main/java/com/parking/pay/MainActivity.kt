package com.parking.pay

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.parking.pay.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // UPI Payment Details
    private val UPI_ADDRESS = "gpay-12196767649@okbizaxis"
    private val PAYEE_NAME = "Parking"
    private val AMOUNT = "15"
    private val CURRENCY = "INR"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the Google Pay button
        binding.payButton.setOnClickListener {
            openGooglePay()
        }
    }

    private fun openGooglePay() {
        // Build UPI URL with default values
        val upiUrl = buildUpiUrl(
            upiAddress = UPI_ADDRESS,
            payeeName = PAYEE_NAME,
            amount = AMOUNT,
            currency = CURRENCY
        )

        // Create intent to open UPI payment
        val upiIntent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(upiUrl)
        }

        // Check if any UPI app is available
        if (upiIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(upiIntent, UPI_REQUEST_CODE)
        } else {
            showError("No UPI application found. Please install Google Pay or another UPI app.")
        }
    }

    private fun buildUpiUrl(
        upiAddress: String,
        payeeName: String,
        amount: String,
        currency: String
    ): String {
        return "upi://pay?pa=$upiAddress&pn=$payeeName&am=$amount&cu=$currency"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            UPI_REQUEST_CODE -> {
                when (resultCode) {
                    RESULT_OK -> {
                        // Payment successful
                        showSuccess("Payment successful!")
                    }
                    RESULT_CANCELED -> {
                        // Payment cancelled
                        showError("Payment cancelled by user")
                    }
                    else -> {
                        // Payment failed
                        showError("Payment failed. Please try again.")
                    }
                }
            }
        }
    }

    private fun showSuccess(message: String) {
        // Show success message (you can use Toast or Snackbar)
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_LONG).show()
    }

    private fun showError(message: String) {
        // Show error message
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_LONG).show()
    }

    companion object {
        private const val UPI_REQUEST_CODE = 100
    }
}
