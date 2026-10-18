# 📊 Counting Sort w Javie

Prosty program konsolowy napisany w **Javie**, który pobiera od użytkownika ciąg liczb całkowitych, a następnie sortuje je za pomocą algorytmu **sortowania przez zliczanie (Counting Sort)**.

Program automatycznie pomija niepoprawne dane (np. litery) i zwraca wynik w dwóch wariantach: pełną posortowaną listę liczb oraz posortowaną listę bez duplikatów.

---

## ✨ Funkcje programu

* 📥 **Interaktywność** – pobiera liczby bezpośrednio z konsoli za pomocą klasy `Scanner`.
* 🛡️ **Walidacja danych** – ignoruje wielokrotne spacje i pomija wartości, których nie można przekonwertować na liczbę całkowitą.
* 🎨 **Kolorowanie komunikatów w terminalu** – wykorzystuje kody ANSI do wyróżniania komunikatów, błędów i wyników.
* 🔄 **Dwa warianty wynikowe**:
    * Pełna posortowana lista liczb, uwzględniająca powtórzenia.
    * Posortowana lista unikalnych liczb, bez duplikatów.
* 🧮 **Sortowanie przez zliczanie** – wykorzystuje pomocniczą tablicę do zliczania wystąpień poszczególnych wartości.
* 📦 **Obiekt wynikowy** – zwraca oba wyniki za pomocą rekordu `CountingSortResult`.

---

## 🚀 Jak uruchomić

### Wymagania wstępne

Do uruchomienia projektu wymagane są:

* **Java 21 lub nowsza** – kod wykorzystuje m.in. metodę `ArrayList.getFirst()` oraz rekordy (`record`).
* **Apache Maven** – do budowania projektu przy użyciu pliku `pom.xml`.

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
5 2 9 2 7 5 1
```

**Wynik w konsoli:**

```text
Counting sort!
Podaj liczby oddzielone spacjami:
Podane liczby:
    [5, 2, 9, 2, 7, 5, 1]

Posortowana tablica:
    [1, 2, 2, 5, 5, 7, 9]

Posortowana tablica bez duplikatow:
    [1, 2, 5, 7, 9]
```

### 🛡️ Przykład walidacji danych

**Dane wejściowe:**

```text
5 abc 2 xyz 5 1
```

Elementy `abc` oraz `xyz` zostaną pominięte, ponieważ nie są poprawnymi liczbami całkowitymi. Program wyświetli odpowiednie komunikaty ostrzegawcze i posortuje pozostałe wartości.

---

## 🛠️ Szczegóły techniczne algorytmu

### Jak działa Counting Sort?

Algorytm `CountingSort.sort(array)` sortuje liczby bez bezpośredniego porównywania ich ze sobą. Zamiast tego zlicza wystąpienia poszczególnych wartości i na tej podstawie odtwarza posortowaną listę.

1. 🔍 **Wyszukiwanie maksimum** – program znajduje największą liczbę w tablicy wejściowej.
2. 🧮 **Tworzenie tablicy liczników** – tworzy pomocniczą tablicę `countArr`, której indeksy odpowiadają wartościom sortowanych liczb.
3. 📊 **Zliczanie wystąpień** – dla każdej liczby zwiększa wartość licznika pod indeksem odpowiadającym tej liczbie.
4. 🔄 **Tworzenie wyniku** – przechodzi przez tablicę liczników w kolejności rosnącej, odtwarzając posortowaną listę wraz z duplikatami.
5. ✅ **Usuwanie duplikatów** – tworzy drugą listę, dodając tylko te wartości, których licznik jest większy od zera.

### 📦 Struktura wyniku

Metoda `CountingSort.sort()` zwraca rekord `CountingSortResult`, który przechowuje dwa wyniki:

* `sortedArray()` – pełna tablica posortowana rosnąco, zawierająca duplikaty.
* `sortedWithoutDuplications()` – posortowana tablica zawierająca wyłącznie unikalne wartości.

Jeżeli tablica wejściowa jest pusta lub ma wartość `null`, metoda wyświetla komunikat o błędzie i zwraca `null`.

---

## ⏱️ Złożoność algorytmu

Dla `n` elementów wejściowych oraz `k = max + 1`, gdzie `max` oznacza największą sortowaną liczbę:

* **Złożoność czasowa:** `O(n + k)`.
* **Złożoność pamięciowa:** `O(k)`, ze względu na pomocniczą tablicę liczników.

Counting Sort sprawdza się szczególnie dobrze przy dużej liczbie elementów o niewielkim zakresie wartości. Gdy największa liczba jest bardzo duża, tablica pomocnicza może wymagać znacznej ilości pamięci.

---

## ⚠️ Ograniczenia

* Program obsługuje wyłącznie **nieujemne liczby całkowite**.
* Liczby ujemne mogą spowodować błąd indeksowania tablicy.
* Bardzo duże wartości mogą prowadzić do wysokiego zużycia pamięci.
* Elementy, których nie można przekonwertować na typ `int`, są pomijane.
* Pusty input lub brak poprawnych liczb nie pozwala wykonać sortowania.

---

## 🧰 Technologie

* ☕ **Java 21+**
* 📦 **Apache Maven**
* 🖥️ **Interfejs konsolowy**
* 🧮 **Counting Sort**
