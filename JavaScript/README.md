# 📊 Counting Sort w Node.js

Prosty program konsolowy napisany w **JavaScript (Node.js)**, który pobiera od użytkownika ciąg liczb, a następnie sortuje je za pomocą algorytmu **sortowania przez zliczanie (Counting Sort)**. 

Program automatycznie usuwa błędne dane (np. litery) i zwraca wynik w dwóch wariantach: pełną posortowaną tablicę oraz posortowaną tablicę bez duplikatów.

---

## ✨ Funkcje programu

* 📥 **Interaktywność** – pobiera dane wejściowe bezpośrednio z konsoli w czasie rzeczywistym.
* 🛡️ **Walidacja danych** – ignoruje wielokrotne spacje, puste znaki oraz wartości, które nie są liczbami.
* 🎨 **Kolorowanie składni w terminalu** – komunikaty o błędach i kluczowe słowa są podświetlane w celu zwiększenia czytelności.
* 🔄 **Dwa tryby wynikowe**:
  * Zwykłe posortowane liczby (wliczając powtórzenia).
  * Posortowane liczby bez duplikatów.

---

## 🚀 Jak uruchomić

### Wymagania wstępne
Do uruchomienia skryptu wymagane jest jedynie środowisko **Node.js** zainstalowane na komputerze. Nie są potrzebne żadne zewnętrzne biblioteki (użyte zostały wyłącznie wbudowane moduły).

### Instrukcja krok po kroku

1. Pobierz lub skopiuj plik z kodem i zapisz go jako `countingSort.js`.
2. Otwórz terminal (Wiersz poleceń / PowerShell / Terminal macOS) w folderze z tym plikiem.
3. Uruchom program za pomocą polecenia:
   ```bash
   node countingSort.js
   ```

---

## 💡 Przykład działania

Po uruchomieniu program poprosi Cię o podanie liczb:

```text
Podaj liczby do posortowania (rozdzielone spacjami): 5 2 9 2 7 5 1
```

**Wynik w konsoli:**
```text
    | Podane przez ciebie liczby:  5 2 9 2 7 5 1
    |-------------------------------------------
    | Posortowane liczby: 1 2 2 5 5 7 9
    | Posortowane liczby bez duplikatów: 1 2 5 7 9
```

---

## 🛠️ Szczegóły techniczne algorytmu

Funkcja `CountingSort(array)` zwraca obiekt zawierający dwa klucze:
* `SortedArray` – Tablica posortowana tradycyjnie.
* `SortedWithoutDuplications` – Tablica przefiltrowana za pomocą metody `.map()` i `.filter()`, która pomija indeksy o zerowej liczbie zliczeń, skutecznie eliminując duplikaty w czasie O(N).
