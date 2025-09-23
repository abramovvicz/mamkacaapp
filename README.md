# MamKaca.pl 🌱

**Aplikacja wspierająca w walce z uzależnieniem od alkoholu**

[![TypeScript](https://img.shields.io/badge/TypeScript-007ACC?style=for-the-badge&logo=typescript&logoColor=white)](https://www.typescriptlang.org/)
[![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)

## 📋 Opis projektu

MamKaca.pl to aplikacja webowa wspierająca osoby w procesie wychodzenia z uzależnienia od alkoholu. Głównym celem jest budowanie zdrowych nawyków poprzez codzienne śledzenie trzeźwości oraz dostarczanie wsparcia i porad w trudnych momentach.

## ✨ Główne funkcjonalności

### 🗓️ Codzienne śledzenie trzeźwości
- Prosty interfejs do codziennego zaznaczania dni bez alkoholu
- Wizualizacja postępów w formie kalendarza/wykresu
- Licznik dni trzeźwości

### 🤝 Inteligentny system wsparcia
- Personalizowany feedback w przypadku wpadki
- Praktyczne porady radzenia sobie z pokusą
- Motywacyjne wiadomości i przypomnienia
- Techniki mindfulness i zarządzania stresem

### 📊 Analityka i raporty
- Śledzenie wzorców i triggerów
- Miesięczne i tygodniowe podsumowania
- Identyfikacja czynników ryzyka

### 🔒 Prywatność i bezpieczeństwo
- Pełna anonimowość użytkowników
- Szyfrowanie danych wrażliwych
- Zgodność z RODO

## 🛠️ Stack technologiczny

### Backend (`backend/`)
- Spring Boot 3 (Java 21)
- Spring Web, Security (SecurityAutoConfiguration obecnie wyłączone w `application.yml`)
- Spring Data MongoDB (baza: MongoDB)
- Actuator, Lombok, Testcontainers

### Frontend (`front/`)
- Vite + React + TypeScript
- Tailwind CSS, shadcn-ui

### Android (`android/`)
- Aplikacja natywna w Kotlinie (Gradle)

### DevOps
- Docker (kontener backendu), Fly.io/Procfile (deploy), SSL (PKCS12)

## 🚀 Instalacja i uruchomienie lokalne

### Wymagania
- Java 21+
- Node.js 18+
- MongoDB (lokalnie lub przez `MONGODB_URI`)
- Docker (opcjonalnie dla backendu)

### Backend

```bash
cd backend
# Uruchomienie w trybie deweloperskim
./gradlew bootRun

# Zmienna środowiskowa wymagana przez Spring Data MongoDB
export MONGODB_URI="mongodb://localhost:27017/mamkaca"

# Alternatywnie: build JAR
./gradlew clean bootJar
java -jar build/libs/mamKaca-0.0.1-SNAPSHOT.jar
```

Konfiguracja serwera (SSL, port, użytkownik security) znajduje się w `backend/src/main/resources/application.yml`. Aplikacja oczekuje pliku `keystore.p12` jeśli SSL jest włączony.

### Frontend

```bash
cd front
npm install
npm run dev
```

### Android

Uruchom w Android Studio lub z linii komend:

```bash
cd android
./gradlew assembleDebug
```

## 🐳 Docker (backend)

W katalogu `backend/` znajduje się `dockerfile` przygotowany do uruchomienia JAR-a.

```bash
cd backend
./gradlew clean bootJar
docker build -t mamkaca-backend -f dockerfile .
docker run -p 8080:8080 -e MONGODB_URI="mongodb://host.docker.internal:27017/mamkaca" \
  -v $(pwd)/keystore.p12:/app/keystore.p12 mamkaca-backend
```

Uwaga: Obraz oczekuje `keystore.p12` w katalogu buildu (kopiowany do kontenera).

## 🏗️ Struktura repozytorium

```
mamkacaapp/
├── backend/
│   ├── src/main/java/pl/mamkaca/...
│   ├── src/main/resources/application.yml
│   ├── build.gradle
│   └── dockerfile
├── front/
│   ├── src/...
│   └── package.json
├── android/
│   └── app/src/main/...
└── README.md
```

## 🔐 Bezpieczeństwo i konfiguracja
- Zmienna `MONGODB_URI` powinna wskazywać na instancję MongoDB (lokalną lub w chmurze).
- W `application.yml` włączone jest SSL i zdefiniowany alias keystore; dostarcz `keystore.p12` lub wyłącz SSL na czas developmentu.
- W `application.yml` znajdują się przykładowe dane konfiguracyjne (użytkownik, hasło) – nie używaj ich w produkcji.

## 🤝 Wkład w projekt

1. Fork repozytorium
2. Utwórz branch (`feature/...`)
3. Commit i push
4. Otwórz Pull Request

## 📄 Licencja

MIT

## 📞 Kontakt

- Strona: [mamkaca.pl](https://mamkaca.pl)
- Issues: repozytorium Git
