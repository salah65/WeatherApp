# Weather Tracker

This simple, modular weather tracking application is built using **Kotlin**, **Jetpack Compose**, and **clean architecture**. The app allows users to search for a city, view its weather details, and persist in their selected city across launches.

---

## Features

- **Home Screen**:
  - Displays the current weather of the saved city.
  - Includes:
    - City name
    - Temperature
    - Weather condition with an icon.
    - Humidity (%).
    - UV index.
    - "Feels like" temperature.
  - Prompts the user to search for a city if none is saved.
- **Search Functionality**:
  - Allows users to search for cities.
  - Displays a result card for queried cities.
  - Updates the home screen and saves the selected city when a result is selected.
- **Local Storage**:
  - Persists the selected city using **SharedPreferences**.
  - Restores the city's weather details on app launch.
- **API Integration**:
  - Fetches weather data from [WeatherAPI.com](https://www.weatherapi.com/docs/).

---

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM with clean architecture
- **Networking**: Retrofit
- **Dependency Injection**: Hilt
- **Image Loading**: Coil
- **Local Storage**: SharedPreferences

---

## Setup Instructions

Follow these steps to set up and run the app:

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/weather-tracker.git
   cd weather-tracker
   ```

2.	Add API Credentials:
	•	Create a file named credentials.properties in the root directory of the project.
	•	Add the following content to the file:
    ```bash
    API_Key="YOUR_API_KEY_HERE"
    Base_Url="https://api.weatherapi.com/v1/"
    ```
  •	Replace YOUR_API_KEY_HERE with your API key from WeatherAPI.com.


3.	Sync and Build:
	•	Open the project in Android Studio.
	•	Sync Gradle to load the credentials.properties file.
	•	Build and run the app on an emulator or a physical device.
## Modular Architecture

The app follows a modular architecture for better scalability, testability, and separation of concerns. The modules are organized as follows:

1. **Core Module**:
   - Contains common utilities and shared resources used across the app.

2. **Features/home Module**:
   - **Data Layer**:
     - Handles API integration using Retrofit.
     - Contains repositories and data sources for fetching and persisting weather data.

3. **Domain Module**:
   - Encapsulates business logic and application rules.
   - Defines use cases that interact with the data layer and are consumed by the presentation layer.

4. **Presentation Module**:
   - Manages the UI using Jetpack Compose.
   - Implements the MVVM pattern with `ViewModel`s for state management and data binding.
   - Ensures seamless user experience and clean state handling.


## API Documentation

This app integrates with WeatherAPI.com. The free tier provides real-time weather data used in the app, including:
	•	Current temperature.
	•	Weather conditions and icons.
	•	Humidity, UV index, and “feels like” temperature.

To learn more, visit the [WeatherAPI.com](https://www.weatherapi.com/docs/).

## Screenshots
<img src="https://github.com/salah65/WeatherApp/blob/master/media/Screenshot_20241215_145521.png?raw=true" alt="App Screenshot" width="300"/>    <img src="https://github.com/salah65/WeatherApp/blob/master/media/Screenshot_20241215_145539.png?raw=true" alt="App Screenshot" width="300"/>
<img src="https://github.com/salah65/WeatherApp/blob/master/media/Screenshot_20241215_150358.png?raw=true" alt="App Screenshot" width="300"/>


	
 
 
