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

### Backend
- **Java Spring Boot** - główny framework backendowy
- **Kotlin** - nowoczesny język JVM dla wybranych modułów
- **Spring Security** - autoryzacja i bezpieczeństwo
- **Spring Data JPA** - warstwa dostępu do danych
- **PostgreSQL** - baza danych
- **Redis** - cache i sesje

### Frontend
- **TypeScript** - typowany JavaScript
- **React/Vue.js** - framework frontendowy
- **Tailwind CSS** - stylizacja
- **PWA** - obsługa offline i notyfikacje push

### DevOps
- **Docker** - konteneryzacja
- **GitHub Actions** - CI/CD
- **Nginx** - reverse proxy
- **Certbot** - certyfikaty SSL

## 🚀 Instalacja i uruchomienie

### Wymagania
- Java 17+
- Node.js 18+
- PostgreSQL 13+
- Redis 6+
- Docker (opcjonalnie)

### Konfiguracja backendu

```bash
# Klonowanie repozytorium
git clone https://github.com/username/mamkaca.pl.git
cd mamkaca.pl

# Konfiguracja bazy danych
cp application.properties.example application.properties
# Edytuj application.properties z własnymi ustawieniami DB

# Uruchomienie backendu
./gradlew bootRun
```

### Konfiguracja frontendu

```bash
cd frontend
npm install
npm run dev
```

### Docker (zalecane dla developmentu)

```bash
docker-compose up -d
```

## 🏗️ Architektura aplikacji

```
mamkaca.pl/
├── backend/
│   ├── src/main/java/pl/mamkaca/
│   │   ├── auth/          # Moduł autoryzacji
│   │   ├── user/          # Zarządzanie użytkownikami
│   │   ├── tracking/      # Śledzenie dni trzeźwości
│   │   ├── support/       # System wsparcia i porad
│   │   ├── analytics/     # Analityka i raporty
│   │   └── notification/  # Powiadomienia
│   ├── src/main/kotlin/   # Moduły w Kotlinie
│   └── src/main/resources/
├── frontend/
│   ├── src/
│   │   ├── components/    # Komponenty React/Vue
│   │   ├── pages/         # Strony aplikacji
│   │   ├── services/      # Komunikacja z API
│   │   └── utils/         # Narzędzia pomocnicze
├── docker-compose.yml
└── README.md
```

## 📱 Funkcjonalności w planach

- [ ] Aplikacja mobilna (React Native/Flutter)
- [ ] Grupy wsparcia online
- [ ] Integracja z wearables (monitorowanie stresu)
- [ ] Chatbot AI do natychmiastowego wsparcia
- [ ] Gamifikacja (odznaczenia, poziomy)
- [ ] Eksport danych do PDF
- [ ] API dla terapeutów/ośrodków leczenia

## 🤝 Wkład w projekt

Każdy wkład w rozwój projektu jest mile widziany! Jeśli chcesz pomóc:

1. **Fork** repozytorium
2. Utwórz **branch** dla swojej funkcjonalności (`git checkout -b feature/nowa-funkcjonalnost`)
3. **Commit** swoje zmiany (`git commit -m 'Dodanie nowej funkcjonalności'`)
4. **Push** do brancha (`git push origin feature/nowa-funkcjonalnost`)
5. Otwórz **Pull Request**

### Obszary, w których potrzebujemy pomocy:
- 🎨 UI/UX Design
- 📱 Rozwój aplikacji mobilnej
- 🔍 Testowanie i QA
- 📚 Dokumentacja
- 🌐 Tłumaczenia
- 🧠 Doradztwo psychologiczne/terapeutyczne

## 📄 Licencja

Ten projekt jest udostępniony na licencji MIT - zobacz plik [LICENSE](LICENSE) po więcej szczegółów.

## 📞 Kontakt i wsparcie

- **Website**: [mamkaca.pl](https://mamkaca.pl)
- **Email**: kontakt@mamkaca.pl
- **Issues**: [GitHub Issues](https://github.com/username/mamkaca.pl/issues)

## ⚠️ Ważne informacje

**MamKaca.pl nie zastępuje profesjonalnej pomocy medycznej czy terapeutycznej.** Jeśli borykasz się z poważnym uzależnieniem, skonsultuj się z lekarzem lub terapeutą.

### Linki do pomocy:
- **Anonimowi Alkoholicy**: [aa.org.pl](https://aa.org.pl)
- **PARPA** (Państwowa Agencja Rozwiązywania Problemów Alkoholowych): [parpa.pl](https://www.parpa.pl)
- **Telefon zaufania**: 116 123

---

**Razem możemy więcej! 💪**

*Jeśli ten projekt pomógł Ci w Twojej drodze do trzeźwości, rozważ podzielenie się swoją historią - może zainspiruje innych do zmiany.*s
