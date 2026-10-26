# 📊 Counting Sort w C++

Prosty program konsolowy napisany w **C++17**, który odczytuje z jednej linii wejścia liczby całkowite, a następnie sortuje je algorytmem **sortowania przez zliczanie (Counting Sort)**.

Program zachowuje odczytane liczby, w tym wartości ujemne i duplikaty. Zwraca dwa wyniki: ciąg posortowany rosnąco ze wszystkimi powtórzeniami oraz listę posortowanych, unikalnych wartości. Znaki, których nie można odczytać jako części liczby całkowitej, są pomijane pojedynczo — dlatego wejście nie jest walidowane jako zestaw rozdzielonych spacjami tokenów.

---

## ✨ Funkcje programu

- 📥 **Odczyt danych z konsoli** — pobiera cały wiersz za pomocą `getline()`.
- 🔎 **Odczytywanie liczb z tekstu** — wykorzystuje `stringstream`; gdy nie może odczytać liczby w bieżącej pozycji, czyści stan strumienia i pomija jeden znak.
- ➖ **Obsługa liczb ujemnych** — algorytm uwzględnia wartości od minimum do maksimum, więc może sortować zarówno liczby ujemne, jak i nieujemne.
- 🧮 **Sortowanie przez zliczanie** — zlicza wystąpienia wartości w pomocniczym wektorze `countArr`.
- 🔢 **Sortowanie rosnące** — odtwarza posortowany wynik na podstawie liczników.
- 🔁 **Obsługa duplikatów** — pełny wynik zachowuje każde wystąpienie liczby.
- ✨ **Lista bez duplikatów** — dodatkowy wektor zawiera każdą występującą wartość tylko raz.
- ⚠️ **Obsługa pustego wyniku parsowania** — jeśli nie uda się odczytać żadnej liczby całkowitej, program wyświetla komunikat o błędzie i kończy działanie.

---

## 🚀 Jak uruchomić

### Wymagania wstępne

- Kompilator obsługujący **C++17** lub nowszy, np. GCC.
- Terminal lub konsola.

### Instrukcja krok po kroku

1. Zapisz kod programu w pliku `main.cpp`.
2. Otwórz terminal w katalogu, w którym znajduje się plik.
3. Skompiluj program:

   ```bash
   g++ -std=c++17 main.cpp -o counting_sort
   ```

4. Uruchom program.

   **Linux / macOS:**

   ```bash
   ./counting_sort
   ```

   **Windows:**

   ```text
   counting_sort.exe
   ```

5. Wpisz liczby lub tekst zawierający liczby, a następnie naciśnij `Enter`.

---

## 💡 Przykład działania

**Dane wejściowe:**

```text
5 2 9 2 7 5 1
```

**Przykładowy wynik w konsoli:**

```text
-- Counting Sort --
Podaj liczby oddzielone spacjami: 5 2 9 2 7 5 1
Podane liczby: 5 2 9 2 7 5 1
Posortowane liczby:
	1 2 2 5 5 7 9 
Posortowane liczby bez duplikatow:
	1 2 5 7 9 
```

Program wyświetla odczytane liczby w kolejności wejściowej, następnie listę posortowaną rosnąco ze wszystkimi wystąpieniami, a na końcu listę bez duplikatów.

### ➖ Przykład z liczbami ujemnymi

**Dane wejściowe:**

```text
5 -2 2 -2 0
```

**Przykładowy wynik:**

```text
-- Counting Sort --
Podaj liczby oddzielone spacjami: 5 -2 2 -2 0
Podane liczby: 5 -2 2 -2 0
Posortowane liczby:
	-2 -2 0 2 5 
Posortowane liczby bez duplikatow:
	-2 0 2 5 
```

Ujemne wartości są obsługiwane przez przesunięcie indeksu licznika o najmniejszą wartość wejściową (`number - minNumber`).

### 🛡️ Przykład pomijania znaków

**Dane wejściowe:**

```text
5 abc -2 2 xyz 5 1
```

W tym przypadku program odczyta również `-2`. Znaki tekstowe zostaną pominięte podczas kolejnych prób odczytu.

**Przykładowy wynik:**

```text
-- Counting Sort --
Podaj liczby oddzielone spacjami: 5 abc -2 2 xyz 5 1
Podane liczby: 5 -2 2 5 1
Posortowane liczby:
	-2 1 2 5 5 
Posortowane liczby bez duplikatow:
	-2 1 2 5 
```

Program nie wyświetla osobnego ostrzeżenia dla każdego pominiętego znaku.

### ⚠️ Przykład pustego wejścia lub braku liczb

Jeśli wprowadzone dane nie pozwolą odczytać żadnej liczby całkowitej, program wyświetli komunikat:

```text
-- Counting Sort --
Podaj liczby oddzielone spacjami:
Blad: Nie podano poprawnych liczb.
```

W takiej sytuacji program kończy działanie bez sortowania.

---

## 🛠️ Jak działa algorytm?

Funkcja `CountingSort(numbers)` zwraca parę wektorów: pełny wynik sortowania i wynik bez duplikatów. Algorytm nie porównuje każdej pary elementów. Zamiast tego zlicza wystąpienia wartości w zakresie od najmniejszej do największej liczby.

1. **Sprawdzenie pustego wektora** — jeśli `numbers` jest pusty, funkcja zwraca dwa puste wektory.
2. **Znalezienie zakresu danych** — `min_element()` i `max_element()` wyznaczają odpowiednio `minNumber` oraz `maxNumber`.
3. **Utworzenie liczników** — `countArr` ma długość `maxNumber - minNumber + 1`. Wartość `number` jest przechowywana pod indeksem `number - minNumber`.
4. **Zliczenie wystąpień** — dla każdej liczby wykonywana jest operacja `countArr[number - minNumber]++`.
5. **Odtworzenie wyników** — program przechodzi po `countArr` od początku do końca. Dla każdej wartości z dodatnim licznikiem dodaje ją raz do `sortedWODuplications`, a do `sortedArr` dodaje ją tyle razy, ile wynosi licznik.
6. **Zwrócenie wyników** — funkcja zwraca `pair<vector<int>, vector<int>>`. W `main()` para jest rozpakowywana za pomocą structured bindings:

   ```cpp
   auto [sortedArray, sortedWODupl] = CountingSort(numbers);
   ```

### 📦 Wykorzystywane wektory

- `numbers` — liczby całkowite odczytane z wejścia, w oryginalnej kolejności.
- `countArr` — liczba wystąpień poszczególnych wartości; indeks jest przesunięty o `minNumber`.
- `sortedArr` — pełna lista posortowana rosnąco, z duplikatami.
- `sortedWODuplications` — lista unikalnych wartości posortowanych rosnąco.

**Przykład:** dla danych wejściowych `3 1 2 3 1`:

Wektor wejściowy:

```cpp
{3, 1, 2, 3, 1}
```

Liczba wystąpień poszczególnych wartości:

```text
Wartość:            1 2 3
Liczba wystąpień:   2 1 2
```

Wyniki:

```cpp
sortedArr             = {1, 1, 2, 3, 3}
sortedWODuplications  = {1, 2, 3}
```

---

## ⏱️ Złożoność algorytmu

Niech:

- `n` oznacza liczbę odczytanych liczb,
- `r = maxNumber - minNumber + 1` oznacza rozpiętość zakresu sortowanych wartości.

Wówczas:

- **Złożoność czasowa:** `O(n + r)` — wyszukanie minimum i maksimum, zliczenie wartości oraz odtworzenie wyników.
- **Złożoność pamięciowa:** `O(n + r)` — wektor liczników ma `r` elementów, a pełny wynik przechowuje `n` liczb.

Counting Sort jest wydajny, gdy rozpiętość wartości jest stosunkowo niewielka. Jeśli wartości są bardzo odległe od siebie, `countArr` może wymagać dużej ilości pamięci, nawet gdy sam wektor wejściowy zawiera niewiele elementów.

---

## ⚠️ Ograniczenia i szczegóły parsowania

- Program operuje na wartościach typu `int`.
- **Liczby ujemne są obsługiwane** — kod nie odrzuca ich podczas wczytywania.
- Parser nie dzieli wejścia na osobne tokeny i nie sprawdza, czy każdy fragment oddzielony spacją jest poprawną liczbą. Przy nieudanej konwersji pomija jeden znak i próbuje odczytu ponownie.
- Z tego powodu tekst otaczający cyfry może zostać pominięty, a liczby znajdujące się w takim tekście mogą zostać odczytane. Na przykład `abc12xyz` może dostarczyć liczbę `12`.
- Liczby zapisane z separatorem dziesiętnym nie są traktowane jako pojedyncze wartości dziesiętne. Na przykład wejście `3.14` może zostać odczytane jako dwie liczby całkowite: `3` i `14`.
- Długość `countArr` zależy od różnicy między największą i najmniejszą liczbą, a nie od samej liczby elementów. Duża rozpiętość może prowadzić do wysokiego zużycia pamięci.
- Skrajne wartości typu `int` mogą spowodować przepełnienie przy obliczaniu `maxNumber - minNumber + 1`; kod nie zabezpiecza tego przypadku.
- Funkcja `CountingSort()` przyjmuje wektor liczb całkowitych i sama nie waliduje zakresu ani bezpieczeństwa alokacji pamięci.

---

## 🧰 Technologie

- 💻 **C++17 lub nowszy**
- 🖥️ **Interfejs konsolowy**
- 🧮 **Counting Sort**
- `std::vector` — przechowywanie danych i wyników
- `std::string` oraz `std::getline()` — pobieranie całej linii wejściowej
- `std::stringstream` — próby odczytu liczb całkowitych z tekstu
- `std::min_element()` i `std::max_element()` — ustalanie zakresu wartości
- `std::pair` oraz **structured bindings** — zwracanie i rozpakowywanie dwóch wektorów
- Biblioteki standardowe: `iostream`, `vector`, `algorithm`, `sstream`, `string` i `utility`
