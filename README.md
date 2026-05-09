# Vehicle Maintenance App

An Android application for tracking vehicle maintenance, services and reminders, built with Java and Firebase.

## Tech Stack

- Java
- Android SDK
- Firebase Authentication
- Firebase Firestore
- Material Design Components

## Features

- User registration and login via Firebase Authentication
- Add and manage vehicles
- Track service history for each vehicle
- Set and manage maintenance reminders
- Edit and delete vehicles, services and reminders

## Getting Started

### Prerequisites

- Android Studio
- Android SDK API 24+
- Firebase account

### Setup

1. Clone the repository:

```bash
git clone https://github.com/PavoBarisic/vehicle-maintenance-app.git
cd vehicle-maintenance-app
```

2. Create a Firebase project at `https://console.firebase.google.com`

3. Add an Android app to your Firebase project with package name:
```
ba.sum.fsre.carmaintenanceapp
```
ba.sum.fsre.carmaintenanceapp

4. Download `google-services.json` from Firebase console and place it in the `app/` folder

5. Enable **Authentication** (Email/Password) and **Firestore** in your Firebase project

6. Open project in Android Studio and run on emulator or device

## Project Structure

| Package | Description |
|---------|-------------|
| Activities | Login, SignUp, MainActivity |
| Fragments | Vehicles, VehicleDetails, Reminders, AddVehicle, AddService, EditDetails |
| Model | Vehicle, Service, Reminder |
| Repository | VehicleRepository — Firebase communication |
| Adapters | VehicleAdapter, ServiceAdapter, ReminderAdapter |

## Notes

- `google-services.json` is not included in the repository for security reasons
- Each developer must create their own Firebase project and add their own `google-services.json`