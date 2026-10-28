# 📊 Counting Sort w Javie

Prosty program konsolowy napisany w **Javie**, który pobiera od użytkownika ciąg liczb całkowitych, a następnie sortuje je za pomocą algorytmu **sortowania przez zliczanie (Counting Sort)**.

Program obsługuje zarówno liczby dodatnie, jak i ujemne. Automatycznie pomija niepoprawne dane (np. litery) i zwraca wynik w dwóch wariantach: pełną posortowaną listę liczb oraz posortowaną listę bez duplikatów.

---

## ✨ Funkcje programu

- 📥 **Interaktywność** – pobiera liczby bezpośrednio z konsoli za pomocą klasy `Scanner`.
- 🛡️ **Walidacja danych** – ignoruje wielokrotne spacje i pomija wartości, których nie można przekonwertować na liczbę całkowitą typu `int`.
- 🎨 **Kolorowanie komunikatów w terminalu** – wykorzystuje kody ANSI do wyróżniania komunikatów, błędów i wyników.
- 🔢 **Obsługa liczb ujemnych** – poprawnie sortuje liczby ujemne, zero i liczby dodatnie.
- 🔄 **Dwa warianty wynikowe**:
    - Pełna posortowana lista liczb, uwzględniająca powtórzenia.
    - Posortowana lista unikalnych liczb, bez duplikatów.
- 🧮 **Sortowanie przez zliczanie** – wykorzystuje pomocniczą tablicę do zliczania wystąpień poszczególnych wartości w zakresie od najmniejszej do największej liczby.
- 📦 **Obiekt wynikowy** – zwraca oba wyniki za pomocą rekordu `CountingSortResult`.

---

## 🚀 Jak uruchomić

### Wymagania wstępne

Do uruchomienia projektu wymagane są:

- **Java 21 lub nowsza** – kod wykorzystuje m.in. metodę `ArrayList.getFirst()` oraz rekordy (`record`).
- **Apache Maven** – do budowania projektu przy użyciu pliku `pom.xml`.

### Instrukcja krok po kroku

1. Pobierz lub sklonuj repozytorium projektu.
2. Otwórz terminal w głównym katalogu projektu, w którym znajduje się plik `pom.xml`.
3. Zbuduj projekt za pomocą polecenia:

   ```bash
   mvn clean package
   ```

4. Uruchom program poleceniem:

   ```bash
   java -cp target/classes org.example.Main
   ```

Program można również uruchomić bezpośrednio z poziomu IDE, np. IntelliJ IDEA, uruchamiając metodę `main()` w klasie `Main`.

---

## 💡 Przykład działania

Po uruchomieniu programu użytkownik zostanie poproszony o podanie liczb oddzielonych spacjami.

**Dane wejściowe:**

```text
5 -2 9 2 -7 5 0 -2 1
```

**Wynik w konsoli:**

```text
Counting sort!
Podaj liczby oddzielone spacjami:
Podane liczby:
    [5, -2, 9, 2, -7, 5, 0, -2, 1]

Posortowana tablica:
    [-7, -2, -2, 0, 1, 2, 5, 5, 9]

Posortowana tablica bez duplikatow:
    [-7, -2, 0, 1, 2, 5, 9]
```

Wynik przedstawia liczby uporządkowane rosnąco, niezależnie od tego, czy są ujemne, zerowe, czy dodatnie.

### 🛡️ Przykład walidacji danych

**Dane wejściowe:**

```text
5 abc -2 xyz 5 -1
```

Elementy `abc` oraz `xyz` zostaną pominięte, ponieważ nie są poprawnymi liczbami całkowitymi. Program wyświetli odpowiednie komunikaty ostrzegawcze i posortuje pozostałe wartości.

**Wynik sortowania:**

```text
[-2, -1, 5, 5]
```

---

## 🛠️ Szczegóły techniczne algorytmu

### Jak działa Counting Sort?

Algorytm `CountingSort.sort(array)` sortuje liczby bez bezpośredniego porównywania ich ze sobą. Zamiast tego zlicza wystąpienia poszczególnych wartości i na tej podstawie odtwarza posortowaną listę.

Aby obsługiwać liczby ujemne, program wyznacza zarówno najmniejszą, jak i największą wartość w tablicy wejściowej.

1. 🔍 **Wyszukiwanie minimum i maksimum** – program znajduje najmniejszą (`minNumber`) oraz największą (`maxNumber`) liczbę w tablicy wejściowej.
2. 🧮 **Tworzenie tablicy liczników** – tworzy pomocniczą tablicę `countArr` o długości `maxNumber - minNumber + 1`. Dzięki przesunięciu indeksów może przechowywać informacje również o liczbach ujemnych.
3. 📊 **Zliczanie wystąpień** – dla każdej liczby zwiększa wartość licznika pod indeksem `number - minNumber`.
4. 🔄 **Tworzenie wyniku** – przechodzi przez tablicę liczników w kolejności rosnącej i odtwarza posortowaną listę wraz z duplikatami. Wartość odpowiadająca indeksowi `i` jest obliczana jako `i + minNumber`.
5. ✅ **Usuwanie duplikatów** – tworzy drugą listę, dodając każdą wartość tylko raz, jeśli jej licznik jest większy od zera.

### 📦 Struktura wyniku

Metoda `CountingSort.sort()` zwraca rekord `CountingSortResult`, który przechowuje dwa wyniki:

- `sortedArray()` – pełna lista posortowana rosnąco, zawierająca duplikaty.
- `sortedWithoutDuplications()` – posortowana lista zawierająca wyłącznie unikalne wartości.

Jeżeli tablica wejściowa jest pusta lub ma wartość `null`, metoda wyświetla komunikat o błędzie i zwraca `null`.

---

## ⏱️ Złożoność algorytmu

Dla `n` elementów wejściowych oraz zakresu wartości `k = maxNumber - minNumber + 1`, gdzie `maxNumber` i `minNumber` oznaczają odpowiednio największą i najmniejszą sortowaną liczbę:

- **Złożoność czasowa:** `O(n + k)`.
- **Złożoność pamięciowa:** `O(k)` dla tablicy liczników, dodatkowo `O(n)` na przechowywanie pełnego wyniku i maksymalnie `O(k)` na listę unikalnych wartości.

Counting Sort sprawdza się szczególnie dobrze przy dużej liczbie elementów o niewielkim zakresie wartości. Algorytm obsługuje liczby ujemne, ale zużycie pamięci zależy od **rozpiętości zakresu wartości**, a nie tylko od największej liczby.

Przykładowo, sortowanie liczb od `-10` do `10` wymaga tablicy liczników o długości `21`. Natomiast sortowanie dwóch liczb `-1000000` i `1000000` wymagałoby tablicy o długości `2000001`.

---

## ⚠️ Ograniczenia

- Program obsługuje liczby całkowite typu `int`, zarówno ujemne, jak i nieujemne.
- Bardzo duża rozpiętość między najmniejszą a największą liczbą może prowadzić do wysokiego zużycia pamięci.
- Elementy, których nie można przekonwertować na typ `int`, są pomijane.
- Puste wejście lub brak poprawnych liczb uniemożliwia wykonanie sortowania.
- Zakres wartości musi być możliwy do obsłużenia przez tablicę w pamięci. Ekstremalne wartości mogą spowodować problemy z obliczeniem rozmiaru tablicy lub przydzieleniem pamięci.

---

## 🧰 Technologie

- ☕ **Java 21+**
- 📦 **Apache Maven**
- 🖥️ **Interfejs konsolowy**
- 🧮 **Counting Sort z obsługą liczb ujemnych**
