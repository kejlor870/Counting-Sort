# 📊 Counting Sort w C++

Prosty program konsolowy napisany w **C++**, który pobiera od użytkownika ciąg liczb całkowitych, a następnie sortuje je za pomocą algorytmu **sortowania przez zliczanie (Counting Sort)**.

Program przyjmuje nieujemne liczby całkowite oddzielone spacjami. Liczby ujemne oraz znaki, których nie można odczytać jako liczby całkowite, są pomijane. Wynik przedstawiany jest jako lista posortowana rosnąco, z zachowaniem wszystkich powtórzeń.

---

## ✨ Funkcje programu

* 📥 **Interaktywność** – pobiera dane od użytkownika bezpośrednio z konsoli za pomocą `getline()`.
* 🛡️ **Walidacja danych** – wykorzystuje `stringstream` do odczytywania liczb całkowitych. Odrzuca liczby ujemne i pomija nieprawidłowe znaki.
* 🧮 **Sortowanie przez zliczanie** – wykorzystuje pomocniczy wektor liczników do zliczania wystąpień poszczególnych wartości.
* 🔄 **Sortowanie rosnące** – tworzy nowy wektor, w którym liczby występują w kolejności od najmniejszej do największej.
* 🔁 **Obsługa duplikatów** – zachowuje wszystkie wystąpienia danej liczby w posortowanym wyniku.
* ✅ **Obsługa pustego wejścia** – wyświetla komunikat o błędzie, jeśli nie podano żadnych poprawnych liczb.
* 📦 **Funkcja sortująca** – funkcja `CountingSort()` zwraca posortowany wektor liczb całkowitych.

---

## 🚀 Jak uruchomić

### Wymagania wstępne

Do uruchomienia projektu wymagane są:

* **Kompilator C++** obsługujący standard C++11 lub nowszy, np. GCC.
* **Terminal lub konsola** do wprowadzania danych i wyświetlania wyników.

### Instrukcja krok po kroku

1. Pobierz lub sklonuj repozytorium projektu.
2. Zapisz kod w pliku, np. `main.cpp`.
3. Otwórz terminal w katalogu, w którym znajduje się plik.
4. Skompiluj program za pomocą polecenia:

   ```bash
   g++ -std=c++11 main.cpp -o counting_sort
   ```

5. Uruchom skompilowany program.

   **Linux / macOS:**

   ```bash
   ./counting_sort
   ```

   **Windows:**

   ```bash
   counting_sort.exe
   ```

6. Po uruchomieniu wpisz nieujemne liczby całkowite oddzielone spacjami i naciśnij `Enter`.

---

## 💡 Przykład działania

Po uruchomieniu programu użytkownik zostanie poproszony o podanie liczb oddzielonych spacjami.

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
```

Program wyświetla najpierw liczby w kolejności podanej przez użytkownika, a następnie wynik sortowania rosnącego.

### 🛡️ Przykład walidacji danych

**Dane wejściowe:**

```text
5 abc -2 2 xyz 5 1
```

Program zapisze nieujemne liczby całkowite, a tekst `abc`, `xyz` oraz liczbę ujemną `-2` pominie.

**Wynik w konsoli:**

```text
-- Counting Sort --
Podaj liczby oddzielone spacjami: 5 abc -2 2 xyz 5 1
Podane liczby: 5 2 5 1
Posortowane liczby:
    1 2 5 5
```

Nieprawidłowe znaki są pomijane podczas odczytywania danych. Program nie wyświetla osobnego komunikatu dla każdego odrzuconego elementu.

### ⚠️ Przykład pustego wejścia

Jeśli użytkownik nic nie wpisze lub poda dane, z których nie zostanie odczytana żadna nieujemna liczba całkowita, program wyświetli komunikat o błędzie.

**Przykładowy wynik w konsoli:**

```text
-- Counting Sort --
Podaj liczby oddzielone spacjami:
Blad: Nie podano poprawnych liczb.
```

Program zakończy działanie bez wyświetlania posortowanego wyniku.

---

## 🛠️ Szczegóły techniczne algorytmu

### Jak działa Counting Sort?

Funkcja `CountingSort(numbers)` sortuje liczby bez bezpośredniego porównywania każdej pary elementów. Zamiast tego zlicza wystąpienia poszczególnych wartości, a następnie na tej podstawie tworzy nowy, posortowany wektor.

1. ✅ **Sprawdzanie danych wejściowych** – funkcja sprawdza, czy wektor jest pusty. Jeśli nie zawiera elementów, zwraca pusty wektor.
2. 🔍 **Wyszukiwanie maksimum** – funkcja `max_element()` znajduje największą wartość w wektorze. Operator `*` pozwala odczytać wartość wskazywaną przez otrzymany iterator.
3. 🧮 **Tworzenie tablicy liczników** – tworzony jest wektor `countArr` wypełniony zerami, o długości `maxNumber + 1`. Indeks każdego elementu odpowiada wartości zliczanej liczby.
4. 📊 **Zliczanie wystąpień** – program przechodzi przez wektor wejściowy i zwiększa odpowiedni licznik za pomocą instrukcji `countArr[index]++`.
5. 🔄 **Tworzenie posortowanego wektora** – program przechodzi przez wektor liczników od indeksu `0` do `maxNumber`. Każda liczba zostaje dodana do wyniku tyle razy, ile wynosi liczba jej wystąpień.
6. 📤 **Zwracanie wyniku** – funkcja `CountingSort()` zwraca wektor `sortedArr`, zawierający liczby posortowane rosnąco.

### 📦 Struktura danych

Program korzysta z trzech głównych wektorów:

* `numbers` – przechowuje poprawne, nieujemne liczby całkowite wprowadzone przez użytkownika.
* `countArr` – przechowuje liczbę wystąpień poszczególnych wartości. Indeks wektora odpowiada wartości liczby.
* `sortedArr` – przechowuje końcowy wynik sortowania.

Przykładowo, dla danych wejściowych:

```text
3 1 2 3 1
```

Wektor wejściowy wygląda następująco:

```cpp
{3, 1, 2, 3, 1}
```

Po zliczeniu wystąpień otrzymujemy:

```text
         Wartość:   0 1 2 3
Liczba wystąpień:   0 2 1 2
```

Na podstawie liczników program tworzy posortowany wektor:

```cpp
{1, 1, 2, 3, 3}
```

Powtórzenia są zachowywane, ponieważ każda wartość jest dodawana do wyniku tyle razy, ile wystąpiła w danych wejściowych.

---

## ⏱️ Złożoność algorytmu

Dla `n` elementów wejściowych oraz `m = maxNumber`, gdzie `maxNumber` oznacza największą sortowaną liczbę:

* **Złożoność czasowa:** `O(n + m)` – obejmuje znalezienie największej wartości, zliczenie wystąpień oraz przejście przez wektor liczników i utworzenie wyniku.
* **Złożoność pamięciowa:** `O(n + m)` – obejmuje wektor liczników o rozmiarze `m + 1` oraz wektor wynikowy przechowujący `n` elementów w przypadku uwzględnienia wszystkich liczb wejściowych.

Counting Sort jest szczególnie przydatny, gdy liczba elementów jest duża, a zakres sortowanych wartości stosunkowo niewielki. Jeśli największa liczba jest bardzo duża, utworzenie wektora liczników może wymagać znacznej ilości pamięci.

---

## ⚠️ Ograniczenia

* Program jest przeznaczony do sortowania **nieujemnych liczb całkowitych**.
* Liczby ujemne są pomijane podczas zapisywania danych w wektorze `numbers`.
* Tekst i nieprawidłowe znaki nie są zapisywane jako liczby. Program pomija je podczas odczytu, ale nie przeprowadza walidacji całych elementów wejściowych jako osobnych tokenów.
* Liczby dziesiętne, np. `3.14`, nie są poprawnie walidowane jako pojedyncze elementy. Ze względu na sposób działania `stringstream` mogą zostać odczytane jako osobne liczby całkowite, np. `3` i `14`.
* Funkcja `CountingSort()` zakłada, że przekazany wektor zawiera wyłącznie nieujemne liczby całkowite. Nie sprawdza samodzielnie, czy elementy spełniają ten warunek.
* Bardzo duże wartości maksymalne mogą powodować wysokie zużycie pamięci, ponieważ wektor `countArr` ma długość równą `maxNumber + 1`.
* Jeśli użytkownik poda pusty ciąg lub nie zostanie odczytana żadna poprawna liczba, program wyświetli komunikat `Blad: Nie podano poprawnych liczb.` zamiast wyniku sortowania.

---

## 🧰 Technologie

* 💻 **C++11 lub nowszy**
* 🖥️ **Interfejs konsolowy**
* 🧮 **Counting Sort**
* 📋 **`std::vector`** – przechowywanie liczb i wyników
* 🔤 **`std::string` oraz `std::getline()`** – odczytywanie danych wejściowych
* 🔄 **`std::stringstream`** – odczytywanie liczb z tekstu
* 🔍 **`std::max_element()`** – wyszukiwanie największej wartości
* 📚 **Biblioteki standardowe C++** – `iostream`, `vector`, `algorithm`, `sstream` oraz `string`
