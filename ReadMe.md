# RealMe
## _Kotlin Multiplatform Showcase_

RealMe is a daily tracker for Habits and Emotional moods, built with Kotlin Multiplatform (KMP) to share logic across Android and iOS.

## Features

### 📝 Add Mood
Allows users to record their emotional state with ease. Each entry is captured with a timestamp, enabling users to look back at their emotional journey.

### 📅 Diary List
Displays a chronological list of all mood entries. This view provides a historical perspective of the user's emotional data.

## Project Structure & Modules

The application is structured to maximize code sharing between platforms:

- **`:shared`**: The core module containing all shared logic:
    - **`domain`**: Contains business models, repository interfaces, and use-case logic.
    - **`data`**: Handles data retrieval and repository implementations.
    - **`redux`**: Implements the Redux pattern for predictable state management.
    - **`ui`**: Shared presentation logic and state holders.
- **`:androidApp`**: Native Android application using Jetpack Compose for the UI.
- **`iosApp`**: Native iOS application using SwiftUI, consuming the shared `:shared` module.

## Architecture

RealMe utilizes the **Redux** pattern for state management. This ensures a unidirectional data flow and a single source of truth, making the application state predictable and easier to debug.

### Redux Components:
- **State**: An immutable representation of the application's current data.
- **Actions**: Dispatched events that signal a change or a request for a change.
- **Reducers**: Pure functions that calculate the new state based on the previous state and the dispatched action.
- **Store**: The central hub that holds the state and handles action dispatching.

[![Redux Flow](https://blog.pusher.com/wp-content/uploads/2017/12/redux-flow.png)](https://blog.pusher.com/wp-content/uploads/2017/12/redux-flow.png)

## Tech Stack

- **Kotlin Multiplatform (KMP)**: Core logic sharing.
- **Jetpack Compose**: Modern UI toolkit for Android.
- **SwiftUI**: Modern UI toolkit for iOS.
- **Redux**: Centralized state management.
- **Koin**: Dependency injection for both shared and platform-specific modules.
- **Kotlinx Serialization**: Multiplatform JSON serialization.
- **Gradle Version Catalog**: Centralized dependency management (`libs.versions.toml`).

## Roadmap

- [ ] **Habits Tracking**: Add the ability to track daily habits.
- [ ] **Data Visualization**: Integrate charts to visualize mood trends over time.
- [ ] **Data Export**: Support for exporting entries as CSV files.
- [ ] **Persistence**: Integrate a local database (e.g., SQLDelight) for permanent data storage.
