# 📚 Ebook Android

A simple Android demo application that displays a grid of eBooks loaded from a bundled JSON file. Tap a cover to learn more about the book and access quick actions.

## Table of Contents
- [Features](#features)
- [Project Structure](#project-structure)
- [Build](#build)
- [Tests](#tests)
- [Contributing](#contributing)
- [License](#license)

## Features
- Parses **data.json** at runtime and populates a two-column `RecyclerView` with book covers and titles.
- Selecting a book opens a dialog presenting **Read**, **Share**, and **Delete** actions.
- Sample book data and cover artwork are stored locally; no network connection is required.

## Project Structure
```
app/
  build.gradle              # Module configuration and dependencies
  src/main/java/com/esentral/ebook/
    MainActivity.java       # Loads JSON data and sets up RecyclerView
    adaptor/BooksListAdaptor.java # Binds books to views and handles dialog actions
    model/Book.java         # Simple data model
  src/main/assets/data.json # Sample book metadata
  src/main/res/             # Layouts, drawables, and other resources
  src/test/                 # Local unit tests
```

## Build
1. Install [Android Studio](https://developer.android.com/studio) or ensure the Android SDK 29+ is available.
2. Clone this repository and run:
   ```bash
   ./gradlew assembleDebug
   ```
   The resulting APK can be found under `app/build/outputs/apk/`.

## Tests
Execute local unit tests with:
```bash
./gradlew test
```
Gradle will attempt to download its wrapper and Android dependencies; an active internet connection and the Android build tools are required.

## Contributing
Pull requests and feature suggestions are welcome! Feel free to fork the project and submit a PR.

## License
This project does not yet include an explicit license.
