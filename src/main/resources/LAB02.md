# LABORATORIUM 02

## Kontynuacja LABORATORIUM 01 oraz stworzenie aspekt logującego wywołania metod serwisów

## ZADANIE 1. Sieciowe API do operacji typu CRUD na Training (bez użycia rekordów)

### Potrzeba biznesowa

Jako użytkownik, chce mieć możliwość dostępu do panelu z treningami:

- tworzenie nowych,
- wyświetlanie swoich treningów,
- aktualizacji trenigów

### Wymagania funkcjonalne

Stworzone API powinno pozwalać na:

- [x] wyszukiwanie wszystkich treningów
- [x] wyszukiwanie treningów dla określonego Użytkownika:
- [x] wyszukiwanie wszystkich treningów zakończonych (po konkretnej zdefiniowanej dacie)
- [x] wyszukiwanie wszystkich treningów dla konkretnej aktywności (np. wszystkie treningi biegowe)
- [x] utworzenie nowego treningu
- [x] aktualizacja treningu (dowolnie wybrane pole np. dystans)

### Wymagania techniczne

- [x] API sieciowe powinno wykorzystywać protokół HTTP oraz format JSON do transferu danych
- [x] w repozytoriach rozwiązanie może wykorzystywać metody dostarczane przez interfejs JpaRepository oraz metody
      domyślne, pobierające dane za pomocą `findAll()` oraz przetwarzające je za pomocą strumieni (`Stream`). Przykład
      znaleźć można w `UserRepository`
- [x] rozwiązanie powinno spełniać zasady SOLID
- [x] rozwiązanie powinno być pokryte testami jednostkowymi (>80%)
- [x] rozwiązanie powinno być odpowiednio zhermetyzowane (nie udostępniać funkcjonalności pozostałym pakietom programu)
- [x] kod powinien być odpowiednio udokumentowany za pomocą JavaDoc
- [x] do kodu powinna zostać dołączona wyeksportowana kolekcja zapytań z programu Postman, pozwalająca przetestować
      stworzone API
- [x] rozwiązanie powinno wykorzystywać zwykłe klasy Javowe do definicji obiektów transferu danych (DTO)

## ZADANIE 2 (opcjonalne). Sieciowe API do operacji typu CRUD na Statistics (bez użycia rekordów)

### Potrzeba biznesowa

### Wymagania funkcjonalne

Stworzone API powinno pozwalać na:

- [x] wylistowanie podstawowych informacji o wszystkich statystykach zapisanych w systemie
- [x] utworzenie nowych statystyk
- [x] aktualizacja Statystyk Użytkownika implementacja funkcjonalności do aktualizacji istniejących statystyk dla
      użytkownika.
- [x] pobranie szczegółów dotyczących statystyk dla danego użytkownika
- [x] usunięcie statystyk
- [x] wyszukiwanie użytkowników po e-mailu, bez rozróżniania wielkości liter, wyszukujące po fragmencie nazwy (zwracane
      tylko ID oraz e-mail użytkowników)
- [x] wyszukiwanie użytkowników po wieku starszym niż zdefiniowany

### Wymagania techniczne

- [x] przygotowanie danych wejściowych (uzupełnienie skryptu ładującego dane przy starcie aplikacji)
- [x] API sieciowe powinno wykorzystywać protokół HTTP oraz format JSON do transferu danych
- [x] w repozytoriach rozwiązanie może wykorzystywać metody dostarczane przez interfejs JpaRepository oraz metody
      domyślne, pobierające dane za pomocą `findAll()` oraz przetwarzające je za pomocą strumieni (`Stream`). Przykład
      znaleźć można w `UserRepository`
- [x] rozwiązanie powinno spełniać zasady SOLID
- [x] rozwiązanie powinno być pokryte testami jednostkowymi (>80%)
- [x] rozwiązanie powinno być odpowiednio zhermetyzowane (nie udostępniać funkcjonalności pozostałym pakietom programu)
- [x] kod powinien być odpowiednio udokumentowany za pomocą JavaDoc
- [x] do kodu powinna zostać dołączona wyeksportowana kolekcja zapytań z programu Postman, pozwalająca przetestować
      stworzone API
- [x] rozwiązanie powinno wykorzystywać zwykłe klasy Javowe do definicji obiektów transferu danych (DTO)
