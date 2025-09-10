# Clean Architecture 🐾

A sample Android app demonstrating : 

**Clean Architecture**, 
**Jetpack Compose**, 
**Hilt DI**, 
**Coroutines**, 
**Retrofit**,
**Testing with JaCoCo coverage**.


## 📂 Project Structure

```

app/
├─ src/main/java/com/msd/cleanarchitecture/
│ ├─ app/ # Application + DI modules
│ ├─ data/ # API + repository implementations
│ ├─ domain/ # Business logic (use cases, models, repo interfaces)
│ └─ feature_animals/ # ViewModel & UI layer (Jetpack Compose)
│
├─ src/test/ # Unit tests (JUnit4, MockK, Coroutines test, MockWebServer)
└─ src/androidTest/ # UI tests (ComposeTestRule, Espresso)


```

## 🚀 Steps to Run

1. Clone this repository:

    ```bash
   git clone https://github.com/manojsinghdeopa/Clean-Architecture.git

2. Open the project in Android Studio.

3. Build and run the app on an emulator or a real device.


## ✅ Testing

## Unit Tests
Run all unit tests:
./gradlew testDebugUnitTest

## UI Tests
Run on connected emulator/device:
./gradlew connectedDebugAndroidTest

## JaCoCo Coverage Generate report:
./gradlew testDebugUnitTest jacocoTestReport

## Open report in browser:
app/build/reports/jacoco/jacocoTestReport/html/index.html

## 🔐 Security
Network Security Config → disables cleartext traffic.
OkHttp can be extended with certificate pinning.
Use EncryptedSharedPreferences for local sensitive storage.

## 🛠 Libraries Used
UI: Jetpack Compose, Material3
DI: Hilt (Dagger)
Networking: Retrofit, OkHttp, Moshi
Async: Kotlin Coroutines
Testing: JUnit4, MockK, Coroutines Test, MockWebServer, Espresso, Compose UI Test
Coverage: JaCoCo

## 📌 Notes
The UI test included is a smoke test.
For deterministic UI tests, create a debug DI module with fake repositories.
Replace BaseUrl with a real API or MockWebServer endpoint.




