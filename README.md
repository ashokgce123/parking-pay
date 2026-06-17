# Parking Pay - Google Pay UPI Integration

A simple Android application that integrates Google Pay for parking payments using UPI (Unified Payments Interface).

## Features

- **Quick Payment**: One-tap Google Pay integration
- **Pre-filled Values**: Default UPI payment details included
- **UPI Support**: Works with all UPI-enabled applications
- **Error Handling**: Graceful handling of payment failures and cancellations

## Payment Details

- **UPI Address**: gpay-12196767649@okbizaxis
- **Payee Name**: Parking
- **Default Amount**: ₹15.00 INR
- **Currency**: INR

## UPI URL Scheme

The app uses the standard UPI payment URL scheme:

```
upi://pay?pa=gpay-12196767649@okbizaxis&pn=Parking&am=15&cu=INR
```

## Requirements

- Android 5.1+ (API level 21+)
- Google Pay or any other UPI-enabled payment app installed
- Internet connection

## Installation

1. Clone the repository
2. Open the project in Android Studio
3. Build and run the application

## How to Use

1. Launch the app
2. Tap the "Pay Now with Google Pay" button
3. Complete the payment in your UPI application
4. Receive confirmation

## Architecture

- **MainActivity**: Handles the main UI and UPI intent launch
- **Activity Result**: Listens for payment completion/cancellation
- **Material Design**: Uses Material Design components for UI

## Permissions Required

- `INTERNET`: For UPI payment processing
- `ACCESS_NETWORK_STATE`: To check network connectivity

## Future Enhancements

- [ ] Add custom amount input
- [ ] Payment history tracking
- [ ] Multiple payment methods
- [ ] Receipt generation
- [ ] Dark mode support

## License

MIT License
