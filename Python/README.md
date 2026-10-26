# 📊 Counting Sort w Pythonie

Prosty program konsolowy napisany w **Pythonie**, który pobiera od użytkownika ciąg liczb całkowitych, a następnie sortuje je za pomocą algorytmu **sortowania przez zliczanie (Counting Sort)**.

Program obsługuje zarówno liczby dodatnie, zero, jak i liczby ujemne. Nieprawidłowe elementy wejściowe, takie jak tekst czy liczby dziesiętne, są pomijane podczas walidacji danych.

Wyniki sortowania prezentowane są w dwóch wariantach:
- Pełna posortowana lista liczb, uwzględniająca powtórzenia.
- Posortowana lista unikalnych liczb, bez duplikatów.

Projekt zawiera również **testy jednostkowe w `pytest`**, które sprawdzają poprawność działania algorytmu dla różnych przypadków wejściowych.

---

## ✨ Funkcje programu

- 📥 **Interaktywność** – pobieranie liczb bezpośrednio z konsoli za pomocą funkcji `input()`.
- 🛡️ **Walidacja danych** – akceptowanie liczb całkowitych zapisanych jako ciągi znaków, w tym liczb ujemnych. Elementy niebędące poprawnymi liczbami całkowitymi są pomijane.
- ➖ **Obsługa liczb ujemnych** – sortowanie liczb dodatnich, ujemnych i zera w ramach jednego zbioru danych.
- 🎨 **Formatowanie komunikatów** – wykorzystanie kodów ANSI do wyświetlania czerwonych komunikatów o błędach oraz pogrubiania wybranego tekstu.
- 🔄 **Dwa warianty wynikowe**:
  - `sorted_arr` – pełna posortowana lista, zawierająca duplikaty.
  - `sorted_wo_duplications` – posortowana lista unikalnych liczb.
- 🧮 **Sortowanie przez zliczanie** – wykorzystanie pomocniczej listy liczników do zliczania wystąpień poszczególnych wartości.
- 📦 **Słownik wynikowy** – funkcja `counting_sort()` zwraca oba wyniki w słowniku.
- ✅ **Obsługa pustego wejścia** – wyświetlenie komunikatu, gdy nie podano żadnych poprawnych liczb.
- 🧪 **Testy jednostkowe w pytest** – sprawdzanie sortowania liczb dodatnich, ujemnych, powtarzających się oraz zera, a także obsługi pustej listy.

---

## 🚀 Jak uruchomić

### Wymagania wstępne

Do uruchomienia projektu wymagane są:

- **Python 3.6 lub nowszy** – program korzysta między innymi z f-stringów.
- **Terminal lub konsola** – do wprowadzania danych i wyświetlania wyników.
- **pytest** – wymagany do uruchomienia testów jednostkowych.

### Instrukcja krok po kroku

1. Pobierz lub sklonuj repozytorium projektu.

   ```bash
   git clone https://github.com/kejlor870/Counting-Sort.git
   ```

2. Przejdź do katalogu projektu w języku Python.

   ```bash
   cd Counting-Sort/Python
   ```

3. Uruchom program:

   ```bash
   python main.py
   ```

   W zależności od konfiguracji systemu możesz użyć również:

   ```bash
   python3 main.py
   ```

   W systemie Windows alternatywą jest:

   ```bash
   py main.py
   ```

4. Wpisz liczby całkowite oddzielone spacjami i naciśnij `Enter`.

### 🧪 Instalacja i uruchamianie testów

Jeśli `pytest` nie jest jeszcze zainstalowany, zainstaluj go za pomocą polecenia:

```bash
python -m pip install pytest
```

Następnie, w katalogu `Python`, uruchom testy:

```bash
python -m pytest
```

Aby uzyskać bardziej szczegółowe informacje o wykonywanych testach, użyj:

```bash
python -m pytest -v
```

Testy znajdują się w pliku `test_main.py` i wykorzystują wzorzec **Arrange–Act–Assert (AAA)** w wybranych przypadkach.

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

Tekst „bez duplikatow” jest dodatkowo pogrubiony za pomocą kodów ANSI.

### ➖ Przykład obsługi liczb ujemnych

**Dane wejściowe:**

```text
4 -2 7 -5 0 2 -2
```

**Przykładowy wynik:**

```text
Podaj liczby rozdzielone spacja: 4 -2 7 -5 0 2 -2
Podane liczby: 4, -2, 7, -5, 0, 2, -2
Posortowana tablica:
     [-5, -2, -2, 0, 2, 4, 7]
Posortowana tablica bez duplikatow:
     [-5, -2, 0, 2, 4, 7]
```

Algorytm poprawnie sortuje liczby ujemne, ponieważ indeks w tablicy liczników obliczany jest przez odjęcie najmniejszej wartości z tablicy wejściowej od sortowanej liczby.

### 🛡️ Przykład walidacji danych

**Dane wejściowe:**

```text
5 abc -2 xyz 5 1 3.5
```

Elementy `abc`, `xyz` oraz `3.5` zostaną pominięte, ponieważ nie są poprawnymi liczbami całkowitymi w przyjętym formacie wejściowym.

**Wynik w konsoli:**

```text
Podane liczby: 5, -2, 5, 1
Posortowana tablica:
     [-2, 1, 5, 5]
Posortowana tablica bez duplikatow:
     [-2, 1, 5]
```

Walidacja wykorzystuje metodę `lstrip('-').isdigit()`, która pozwala zaakceptować ciągi zaczynające się od znaku minus, a następnie złożone z cyfr. Nie jest to jednak pełna walidacja wszystkich możliwych zapisów liczb.

### ⚠️ Przykład pustego wejścia

Jeżeli użytkownik nic nie wpisze lub poda wyłącznie elementy odrzucone podczas walidacji, funkcja otrzyma pustą listę.

Wówczas wyświetli czerwony komunikat:

```text
Nie podano poprawnych liczb.
```

Funkcja `counting_sort()` zwróci `None`, a program nie wyświetli posortowanych list.

---

## 🛠️ Szczegóły techniczne algorytmu

### Jak działa Counting Sort?

Funkcja `counting_sort(array)` sortuje liczby bez bezpośredniego porównywania ich ze sobą. Zamiast tego zlicza wystąpienia poszczególnych wartości i na tej podstawie odtwarza posortowaną listę.

1. 🔍 **Sprawdzenie danych wejściowych** – funkcja sprawdza, czy lista nie jest pusta. Jeśli nie zawiera żadnych elementów, wyświetla komunikat i zwraca `None`.
2. 🔎 **Wyznaczenie zakresu wartości** – funkcja znajduje największą liczbę za pomocą `max(array)` oraz najmniejszą za pomocą `min(array)`.
3. 🧮 **Utworzenie tablicy liczników** – tworzona jest lista `count_arr` o długości `max_number - min_number + 1`. Dzięki temu obsługiwane są również liczby ujemne.
4. 📊 **Zliczanie wystąpień** – dla każdej liczby zwiększany jest odpowiedni licznik:

   ```python
   count_arr[number - min_number] += 1
   ```

   Odjęcie `min_number` przesuwa indeksy tak, aby najmniejsza wartość odpowiadała indeksowi `0`.

5. 🔄 **Odtworzenie posortowanych danych** – funkcja przechodzi przez tablicę liczników w kolejności rosnącej i dodaje każdą wartość do listy wynikowej tyle razy, ile wynosi liczba jej wystąpień.
6. ✅ **Utworzenie listy unikalnych liczb** – każda wartość występująca co najmniej raz jest dodawana tylko raz do listy `sorted_wo_duplications`.

### 📦 Struktura wyniku

Funkcja `counting_sort()` zwraca słownik zawierający dwa wyniki:

- `sorted_arr` – pełna lista posortowana rosnąco, zawierająca duplikaty.
- `sorted_wo_duplications` – posortowana lista zawierająca wyłącznie unikalne wartości.

Przykładowo, dla wejścia `[-3, 2, -3, 0, 2]` funkcja zwróci:

```python
{
    "sorted_arr": [-3, -3, 0, 2, 2],
    "sorted_wo_duplications": [-3, 0, 2]
}
```

Jeśli lista wejściowa jest pusta, funkcja zwraca `None`.

---

## 🧪 Testy jednostkowe w pytest

Projekt zawiera testy jednostkowe w pliku `test_main.py`. Ich celem jest sprawdzenie poprawności działania algorytmu dla różnych danych wejściowych.

### Zakres testów

| Test | Co sprawdza |
|---|---|
| `test_counting_sort_positive_numbers` | Sortowanie liczb dodatnich. |
| `test_counting_sort_negative_postive_numbers` | Sortowanie liczb ujemnych, dodatnich oraz zera w jednej tablicy. |
| `test_counting_sort_wo_duplicates` | Poprawne usuwanie duplikatów z wyniku. |
| `test_counting_sort_empty_array` | Zwracanie `None` dla pustej listy. |
| `test_counting_sort_only_zeros` | Poprawne sortowanie listy zawierającej same zera. |
| `test_counting_sort_negative_duplicated` | Obsługa powtarzających się liczb ujemnych w obu wariantach wyniku. |

### Uruchamianie testów

W katalogu zawierającym pliki `main.py` i `test_main.py` wykonaj:

```bash
python -m pytest -v
```

`pytest` automatycznie wykryje funkcje testowe rozpoczynające się od `test_` i uruchomi każdą z nich.

Testy korzystają z instrukcji `assert`, które porównują rzeczywiste wyniki działania funkcji z oczekiwanymi wartościami. Wybrane testy wykorzystują schemat **Arrange–Act–Assert**:

- **Arrange** – przygotowanie danych testowych.
- **Act** – wywołanie testowanej funkcji.
- **Assert** – sprawdzenie poprawności wyniku.

---

## ⏱️ Złożoność algorytmu

Dla `n` elementów wejściowych oraz zakresu wartości `k = max_number - min_number + 1`:

- **Złożoność czasowa:** `O(n + k)` – zliczanie elementów wymaga przejścia przez listę wejściową, a odtworzenie wyniku przez zakres liczników.
- **Złożoność pamięciowa:** `O(k)` dla pomocniczej listy liczników. Po uwzględnieniu list wynikowych całkowite dodatkowe zapotrzebowanie na pamięć wynosi `O(k + n)`.

Algorytm jest szczególnie efektywny, gdy liczba elementów jest duża, a zakres wartości stosunkowo niewielki.

Należy jednak pamiętać, że zapotrzebowanie na pamięć zależy od **rozpiętości zakresu wartości**, a nie tylko od największej liczby. Przykładowo, dla dwóch liczb `-1_000_000` i `1_000_000` tablica liczników będzie miała ponad dwa miliony elementów, mimo że wejście zawiera tylko dwie liczby.

---

## ⚠️ Ograniczenia

- Program obsługuje liczby całkowite, w tym wartości ujemne i zero.
- Program konsolowy akceptuje liczby zapisane jako ciągi cyfr z opcjonalnym początkowym znakiem minus. Liczby dziesiętne, tekst oraz inne nieobsługiwane formaty są pomijane.
- Walidacja `lstrip('-').isdigit()` nie obsługuje poprawnie wszystkich możliwych zapisów liczb. Przykładowo, ciąg `--5` może przejść kontrolę `isdigit()` po usunięciu znaków minus, a następnie spowodować błąd podczas konwersji przez `int()`. Samo `-` zostanie odrzucone.
- Funkcja `counting_sort()` zakłada, że otrzymuje listę liczb całkowitych. Nie przeprowadza walidacji typów danych przekazanych bezpośrednio jako argument.
- Duża rozpiętość między najmniejszą a największą wartością może prowadzić do znacznego zużycia pamięci.
- Puste wejście powoduje wyświetlenie komunikatu o błędzie i zwrócenie `None`.
- Kody ANSI odpowiedzialne za kolory i pogrubienie mogą być wyświetlane inaczej w zależności od terminala.

---

## 🧰 Technologie

- 🐍 **Python 3.6+**
- 🖥️ **Interfejs konsolowy**
- 🧮 **Counting Sort** z obsługą liczb ujemnych
- 📋 **Listy i słowniki Pythona**
- 🎨 **Kody ANSI** do formatowania komunikatów
- 🧪 **pytest** do testów jednostkowych
