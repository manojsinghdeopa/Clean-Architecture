# 🐾 CleanArchitecture

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

## 🚀 Run the App
1. Open project in **Android Studio (Giraffe or newer)**.
2. Build and run on an emulator or device.


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
Replace https://example.com/ with a real API or MockWebServer endpoint.




