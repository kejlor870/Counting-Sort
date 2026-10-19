# 📊 Counting Sort w Pythonie

Prosty program konsolowy napisany w **Pythonie**, który pobiera od użytkownika ciąg liczb całkowitych, a następnie sortuje je za pomocą algorytmu **sortowania przez zliczanie (Counting Sort)**.

Program pomija elementy wejściowe, które nie przechodzą wstępnej walidacji, np. tekst i liczby zapisane ze znakiem minus. Zwraca wynik w dwóch wariantach: pełną posortowaną listę liczb, uwzględniającą powtórzenia, oraz posortowaną listę bez duplikatów.

---

## ✨ Funkcje programu

* 📥 **Interaktywność** – pobiera liczby bezpośrednio z konsoli za pomocą funkcji `input()`.
* 🛡️ **Walidacja danych** – wykorzystuje metodę `isdigit()`, aby wybrać elementy składające się z cyfr. Pozostałe elementy wejściowe są pomijane.
* 🎨 **Kolorowanie komunikatów w terminalu** – wykorzystuje kody ANSI do wyświetlania czerwonego komunikatu o błędzie oraz pogrubiania wybranego tekstu.
* 🔄 **Dwa warianty wynikowe**:
    * Pełna posortowana lista liczb, uwzględniająca powtórzenia.
    * Posortowana lista unikalnych liczb, bez duplikatów.
* 🧮 **Sortowanie przez zliczanie** – wykorzystuje pomocniczą listę liczników do zliczania wystąpień poszczególnych wartości.
* 📦 **Słownik wynikowy** – funkcja `counting_sort()` zwraca oba wyniki w słowniku, pod kluczami `sorted_arr` i `sorted_wo_duplications`.
* ✅ **Obsługa pustego wejścia** – wyświetla komunikat, gdy nie podano żadnych poprawnych liczb.

---

## 🚀 Jak uruchomić

### Wymagania wstępne

Do uruchomienia projektu wymagane są:

* **Python 3.6 lub nowszy** – program korzysta m.in. z f-stringów.
* **Terminal lub konsola** – do wprowadzania danych i wyświetlania wyników.

### Instrukcja krok po kroku

1. Pobierz lub sklonuj repozytorium projektu.
2. Zapisz kod w pliku, np. `counting_sort.py`.
3. Otwórz terminal w katalogu, w którym znajduje się plik.
4. Uruchom program za pomocą polecenia:

   ```bash
   python counting_sort.py
   ```

   W zależności od konfiguracji systemu możesz użyć również:

   ```bash
   python3 counting_sort.py
   ```

   W systemie Windows alternatywą jest:

   ```bash
   py counting_sort.py
   ```

5. Po uruchomieniu wpisz nieujemne liczby całkowite oddzielone spacjami i naciśnij `Enter`.

---

## 💡 Przykład działania

Po uruchomieniu programu użytkownik zostanie poproszony o podanie liczb oddzielonych spacjami.

**Dane wejściowe:**

```text
5 2 9 2 7 5 1
```

**Przykładowy wynik w konsoli:**

```text
Podaj liczby rozdzielone spacja: 5 2 9 2 7 5 1
Podane liczby: 5, 2, 9, 2, 7, 5, 1
Posortowana tablica:
     [1, 2, 2, 5, 5, 7, 9]
Posortowana tablica bez duplikatow:
     [1, 2, 5, 7, 9]
```

W terminalu tekst „bez duplikatow” jest dodatkowo pogrubiony za pomocą kodów ANSI.

### 🛡️ Przykład walidacji danych

**Dane wejściowe:**

```text
5 abc 2 xyz 5 1
```

Elementy `abc` oraz `xyz` zostaną pominięte, ponieważ nie składają się wyłącznie z cyfr. Program posortuje pozostałe wartości.

**Wynik w konsoli:**

```text
Podane liczby: 5, 2, 5, 1
Posortowana tablica:
     [1, 2, 5, 5]
Posortowana tablica bez duplikatow:
     [1, 2, 5]
```

### ⚠️ Przykład pustego wejścia

Jeżeli użytkownik nic nie wpisze lub poda wyłącznie elementy, które zostaną odrzucone podczas walidacji, funkcja otrzyma pustą listę. Wyświetli wówczas czerwony komunikat:

```text
Nie podano poprawnych liczb.
```

Program nie wyświetli wtedy list posortowanych wyników.

---

## 🛠️ Szczegóły techniczne algorytmu

### Jak działa Counting Sort?

Funkcja `counting_sort(array)` sortuje liczby bez bezpośredniego porównywania ich ze sobą. Zamiast tego zlicza wystąpienia poszczególnych wartości i na tej podstawie tworzy posortowane listy.

1. 🔍 **Sprawdzanie danych wejściowych** – program sprawdza, czy lista jest niepusta. Jeśli lista nie zawiera żadnych elementów, wyświetla komunikat i zwraca `None`.
2. 🔎 **Wyszukiwanie maksimum** – funkcja znajduje największą liczbę w tablicy wejściowej za pomocą `max(array)`.
3. 🧮 **Tworzenie tablicy liczników** – tworzy listę `count_arr` wypełnioną zerami, o długości `max_number + 1`. Indeks każdego elementu odpowiada wartości zliczanej liczby.
4. 📊 **Zliczanie wystąpień** – dla każdej liczby z tablicy wejściowej zwiększa odpowiedni licznik za pomocą `count_arr[number] += 1`.
5. 🔄 **Tworzenie posortowanej listy** – program przechodzi przez listę liczników w kolejności rosnącej. Wartości są dodawane do wyniku tyle razy, ile wynosi liczba ich wystąpień.
6. ✅ **Usuwanie duplikatów** – równocześnie tworzona jest druga lista, do której każda występująca wartość dodawana jest tylko raz.

### 📦 Struktura wyniku

Funkcja `counting_sort()` zwraca słownik zawierający dwa wyniki:

* `sorted_arr` – pełna lista posortowana rosnąco, zawierająca duplikaty.
* `sorted_wo_duplications` – posortowana lista zawierająca wyłącznie unikalne wartości.

Przykładowo, dla wejścia `[5, 2, 5, 1, 2]` funkcja zwróci słownik o następującej strukturze:

```python
{
    "sorted_arr": [1, 2, 2, 5, 5],
    "sorted_wo_duplications": [1, 2, 5]
}
```

Jeśli lista wejściowa jest pusta, funkcja zwraca `None`. W części głównej programu wynik jest sprawdzany przed wyświetleniem posortowanych list.

---

## ⏱️ Złożoność algorytmu

Dla `n` elementów wejściowych oraz `k = max + 1`, gdzie `max` oznacza największą sortowaną liczbę:

* **Złożoność czasowa:** `O(n + k)` – algorytm przechodzi przez dane wejściowe, a następnie przez listę liczników.
* **Złożoność pamięciowa:** `O(k)` dla pomocniczej listy liczników. Po uwzględnieniu list wynikowych całkowite dodatkowe zapotrzebowanie na pamięć wynosi `O(k + n)`.

Counting Sort sprawdza się szczególnie dobrze przy dużej liczbie elementów o stosunkowo niewielkim zakresie wartości. Gdy największa liczba jest bardzo duża, lista liczników może wymagać znacznej ilości pamięci, nawet jeśli lista wejściowa zawiera niewiele elementów.

---

## ⚠️ Ograniczenia

* Program jest przeznaczony do sortowania **nieujemnych liczb całkowitych**.
* W części głównej programu metoda `isdigit()` pomija m.in. liczby ujemne zapisane ze znakiem `-`, liczby dziesiętne oraz tekst zawierający litery.
* Funkcja `counting_sort()` sama w sobie nie waliduje, czy wszystkie przekazane elementy są nieujemnymi liczbami całkowitymi. Przekazanie wartości ujemnych lub innych nieobsługiwanych danych bezpośrednio do funkcji może spowodować niepoprawny wynik albo błąd.
* Bardzo duże wartości maksymalne mogą prowadzić do wysokiego zużycia pamięci, ponieważ lista liczników ma długość równą `max_number + 1`.
* Metoda `isdigit()` nie jest pełną walidacją konwersji do typu `int`. Niektóre nietypowe znaki Unicode mogą zostać uznane za cyfry, mimo że `int()` nie potrafi ich przekonwertować.
* Puste wejście lub brak elementów zaakceptowanych przez walidację powoduje wyświetlenie komunikatu o błędzie zamiast wyników sortowania.
* Kody ANSI odpowiedzialne za kolory i pogrubienie mogą być wyświetlane inaczej w zależności od terminala.

---

## 🧰 Technologie

* 🐍 **Python 3.6+**
* 🖥️ **Interfejs konsolowy**
* 🧮 **Counting Sort**
* 📋 **Listy i słowniki Pythona**
* 🎨 **Kody ANSI** do formatowania komunikatów w terminalu
