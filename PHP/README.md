# 📊 Counting Sort w PHP

Prosty program konsolowy napisany w **PHP**, który pobiera od użytkownika ciąg liczb, a następnie sortuje je za pomocą algorytmu **sortowania przez zliczanie (Counting Sort)**.

Program przyjmuje liczby oddzielone spacjami. Nieprawidłowe elementy tekstowe są pomijane, a pozostałe wartości są konwertowane na liczby całkowite za pomocą `intval()`. Wynik przedstawiany jest w dwóch postaciach: jako posortowana tablica zawierająca wszystkie powtórzenia oraz jako tablica zawierająca wyłącznie unikalne wartości.

**Uwaga:** algorytm jest przeznaczony do sortowania nieujemnych liczb całkowitych. Aktualna implementacja nie odrzuca liczb ujemnych ani nie sprawdza, czy wartości liczbowe są całkowite przed ich konwersją.

---

## ✨ Funkcje programu

* 📥 **Interaktywność** – pobiera dane od użytkownika bezpośrednio z konsoli za pomocą `readline()`.
* 🛡️ **Walidacja danych** – wykorzystuje `array_filter()` oraz `is_numeric()` do pomijania elementów, których nie można rozpoznać jako liczb.
* 🔢 **Konwersja danych** – funkcja `intval()` przekształca rozpoznane wartości na liczby całkowite.
* 🧮 **Sortowanie przez zliczanie** – wykorzystuje pomocniczą tablicę liczników do zliczania wystąpień poszczególnych wartości.
* 🔄 **Sortowanie rosnące** – tworzy nową tablicę, w której liczby występują od najmniejszej do największej.
* 🔁 **Obsługa duplikatów** – zachowuje wszystkie wystąpienia danej liczby w pełnym posortowanym wyniku.
* ✅ **Tablica bez duplikatów** – zwraca również posortowaną listę unikalnych wartości.
* 🚫 **Obsługa pustego wejścia** – wyświetla komunikat o błędzie, jeśli po przetworzeniu danych nie pozostanie żadna liczba.
* 📦 **Funkcja sortująca** – funkcja `countingSort()` zwraca dwuelementową tablicę zawierającą wynik pełnego sortowania oraz wynik bez duplikatów.

---

## 🚀 Jak uruchomić

### Wymagania wstępne

Do uruchomienia projektu wymagane są:

* **PHP 7.1 lub nowszy** – ze względu na zastosowanie składni rozpakowywania tablic.
* **PHP CLI** – do uruchamiania programu w terminalu.
* **Obsługa funkcji `readline()`** – środowisko PHP musi udostępniać tę funkcję.
* **Terminal lub konsola** – do wprowadzania danych i wyświetlania wyników.

### Struktura projektu

Oba pliki PHP powinny znajdować się w tym samym katalogu:

```text
CountingSort/
├── main.php
└── countingSort.php
```

Plik `main.php` odpowiada za pobieranie i przetwarzanie danych wejściowych, natomiast `countingSort.php` zawiera implementację algorytmu sortowania.

### Instrukcja krok po kroku

1. Pobierz lub sklonuj repozytorium projektu.
2. Umieść pliki `main.php` oraz `countingSort.php` w tym samym katalogu.
3. Otwórz terminal w katalogu projektu.
4. Sprawdź, czy PHP jest zainstalowane, za pomocą polecenia:

   ```bash
   php -v
   ```

5. Uruchom program:

   ```bash
   php main.php
   ```

6. Wpisz liczby oddzielone spacjami, a następnie naciśnij `Enter`.

Program wyświetli wprowadzone liczby, ich posortowaną wersję oraz listę bez duplikatów.

---

## 💡 Przykład działania

Po uruchomieniu programu użytkownik zostanie poproszony o podanie liczb oddzielonych spacjami.

**Dane wejściowe:**

```text
5 2 9 2 7 5 1
```

**Przykładowy wynik w konsoli:**

```text
Podaj liczby oddzielone spacjami: 5 2 9 2 7 5 1
Podane liczby: 5 2 9 2 7 5 1
Posortowana tablica:
    1 2 2 5 5 7 9
Posortowana tablica bez duplikatow:
    1 2 5 7 9
```

Program najpierw wyświetla liczby w kolejności podanej przez użytkownika. Następnie prezentuje wynik sortowania rosnącego, zachowując wszystkie powtórzenia. Na końcu wyświetla posortowaną listę unikalnych wartości.

### 🔁 Przykład obsługi duplikatów

**Dane wejściowe:**

```text
3 1 2 3 1 2 3
```

**Wynik w konsoli:**

```text
Podaj liczby oddzielone spacjami: 3 1 2 3 1 2 3
Podane liczby: 3 1 2 3 1 2 3
Posortowana tablica:
    1 1 2 2 3 3 3
Posortowana tablica bez duplikatow:
    1 2 3
```

W pełnym wyniku każda liczba występuje tyle razy, ile pojawiła się w danych wejściowych. W tablicy bez duplikatów każda wartość występuje tylko raz.

### 🛡️ Przykład walidacji danych

**Dane wejściowe:**

```text
5 abc 2 xyz 5 1
```

Program pominie tekstowe elementy `abc` oraz `xyz`, ponieważ nie są one poprawnymi wartościami liczbowymi według funkcji `is_numeric()`.

**Wynik w konsoli:**

```text
Podaj liczby oddzielone spacjami: 5 abc 2 xyz 5 1
Podane liczby: 5 2 5 1
Posortowana tablica:
    1 2 5 5
Posortowana tablica bez duplikatow:
    1 2 5
```

Nieprawidłowe elementy są pomijane bez wyświetlania osobnego komunikatu dla każdego z nich.

### ⚠️ Przykład pustego wejścia

Jeśli użytkownik nie wpisze żadnej liczby lub poda wyłącznie elementy, które nie zostaną rozpoznane jako wartości liczbowe, program wyświetli komunikat o błędzie.

**Przykładowe dane wejściowe:**

```text
abc xyz
```

**Wynik w konsoli:**

```text
Podaj liczby oddzielone spacjami: abc xyz
Podane liczby:
Blad: Przekazano pusta tablice liczb!
```

Program zakończy działanie za pomocą instrukcji `exit`, nie wykonując sortowania.

---

## 🛠️ Szczegóły techniczne algorytmu

### Jak działa Counting Sort?

Funkcja `countingSort($numbers)` sortuje liczby bez bezpośredniego porównywania poszczególnych par elementów. Zamiast tego zlicza wystąpienia każdej wartości, a następnie na podstawie tych informacji tworzy posortowaną tablicę.

1. ✅ **Sprawdzenie danych wejściowych** – funkcja `empty()` sprawdza, czy przekazana tablica zawiera elementy. Jeśli jest pusta, funkcja zwraca dwie puste tablice.
2. 🔍 **Wyszukiwanie największej liczby** – funkcja `max()` wyznacza największą wartość wejściową. Wynik jest dodatkowo konwertowany na liczbę całkowitą za pomocą `intval()`.
3. 🧮 **Tworzenie tablicy liczników** – funkcja `array_fill()` tworzy tablicę `countArr` wypełnioną zerami. Jej długość wynosi `maxNumber + 1`, dzięki czemu indeks może odpowiadać wartości zliczanej liczby.
4. 📊 **Zliczanie wystąpień** – pętla `foreach` przechodzi przez liczby wejściowe i zwiększa odpowiedni licznik za pomocą instrukcji `$countArr[$number]++`.
5. 🔁 **Tworzenie tablicy bez duplikatów** – funkcja `array_filter()` usuwa elementy, których wartość licznika wynosi zero. Następnie `array_keys()` zwraca indeksy pozostałych elementów, czyli wartości występujące w danych wejściowych.
6. 🔄 **Tworzenie posortowanej tablicy** – pętla `for` przechodzi po tablicy liczników od indeksu `0` do `maxNumber`. Instrukcja `while` dodaje każdą liczbę do wyniku tyle razy, ile wynosi jej licznik.
7. 📤 **Zwracanie wyników** – funkcja zwraca dwuelementową tablicę zawierającą pełny wynik sortowania i wynik bez duplikatów. W pliku `main.php` wartości są rozpakowywane za pomocą składni `[$sorted, $sortedWODupl]`.

### 📦 Struktura danych

Program korzysta z czterech głównych tablic:

* `numbers` – przechowuje liczby wprowadzone przez użytkownika po przefiltrowaniu i konwersji na typ całkowity.
* `countArr` – przechowuje liczbę wystąpień poszczególnych wartości. Indeks tablicy odpowiada wartości liczby.
* `sortedArr` – przechowuje wynik sortowania ze wszystkimi powtórzeniami.
* `sortedWODuplications` – przechowuje wartości, które wystąpiły w danych wejściowych, w kolejności rosnącej i bez duplikatów.

Przykładowo, dla danych wejściowych:

```text
3 1 2 3 1
```

Tablica wejściowa wygląda następująco:

```php
[3, 1, 2, 3, 1]
```

Po zliczeniu wystąpień otrzymujemy:

```text
Wartość:             0  1  2  3
Liczba wystąpień:    0  2  1  2
```

Na podstawie tablicy liczników program tworzy pełny wynik:

```php
[1, 1, 2, 3, 3]
```

Oraz tablicę bez duplikatów:

```php
[1, 2, 3]
```

Powtórzenia są zachowywane w `sortedArr`, ponieważ każda wartość jest dodawana tyle razy, ile wystąpiła w danych wejściowych. W tablicy `sortedWODuplications` każda wartość pojawia się tylko raz.

### 🔗 Podział odpowiedzialności między plikami

**`main.php`**

* Pobiera dane za pomocą `readline()`.
* Dzieli wprowadzony tekst na elementy przy użyciu `explode()`.
* Usuwa puste elementy i filtruje dane za pomocą `array_filter()`.
* Konwertuje wartości na liczby całkowite za pomocą `array_map()` i `intval()`.
* Sprawdza, czy tablica liczb jest pusta.
* Wywołuje funkcję `countingSort()`.
* Wyświetla dane wejściowe oraz oba wyniki sortowania.

**`countingSort.php`**

* Definiuje funkcję `countingSort($numbers)`.
* Wyszukuje największą wartość przy użyciu `max()`.
* Tworzy tablicę liczników za pomocą `array_fill()`.
* Zlicza wystąpienia liczb.
* Przygotowuje tablicę bez duplikatów.
* Buduje pełną posortowaną tablicę.
* Zwraca oba wyniki w jednej tablicy.

Dzięki takiemu podziałowi kod odpowiedzialny za pobieranie i prezentację danych jest oddzielony od implementacji algorytmu sortowania.

---

## ⏱️ Złożoność algorytmu

Dla `n` elementów wejściowych oraz `m = maxNumber`, gdzie `maxNumber` oznacza największą sortowaną liczbę, złożoność algorytmu można opisać następująco:

* **Złożoność czasowa:** `O(n + m)` – obejmuje znalezienie największej wartości, zliczanie wystąpień, filtrowanie tablicy liczników i tworzenie wyniku sortowania.
* **Złożoność pamięciowa:** `O(n + m)` – obejmuje tablicę liczników o rozmiarze `m + 1`, tablice wynikowe oraz tablicę liczb wejściowych.

Counting Sort jest szczególnie przydatny, gdy liczba elementów jest duża, a zakres sortowanych wartości stosunkowo niewielki.

Jeżeli największa liczba jest bardzo duża, utworzenie tablicy `countArr` może wymagać znacznej ilości pamięci. Z tego powodu algorytm nie zawsze będzie dobrym wyborem dla danych zawierających nieliczne, ale bardzo duże wartości.

---

## ⚠️ Ograniczenia

* **Nieobsługiwane liczby ujemne** – algorytm zakłada, że wszystkie wartości są nieujemnymi liczbami całkowitymi. Obecna implementacja nie odrzuca liczb ujemnych, dlatego mogą one prowadzić do niepoprawnego wyniku lub błędu.
* **Brak pełnej walidacji liczb całkowitych** – funkcja `is_numeric()` rozpoznaje również liczby dziesiętne, np. `3.14`. Następnie `intval()` konwertuje taką wartość na `3`, co oznacza utratę części ułamkowej.
* **Liczby w notacji wykładniczej** – wartości takie jak `1e3` również mogą zostać zaakceptowane przez `is_numeric()` i skonwertowane przez `intval()`.
* **Podział danych spacją** – program używa `explode(' ', ...)`, więc rozdziela elementy za pomocą zwykłej spacji. Dane oddzielone wyłącznie tabulatorami nie są obsługiwane w taki sam sposób.
* **Duże wartości maksymalne** – rozmiar tablicy liczników zależy od największej wartości. Bardzo duże liczby mogą powodować znaczne zużycie pamięci.
* **Brak komunikatu dla każdego odrzuconego elementu** – nieprawidłowy tekst jest pomijany bez dodatkowego ostrzeżenia.
* **Zależność od środowiska PHP** – funkcja `readline()` musi być dostępna w środowisku, w którym program jest uruchamiany.

Aby uzyskać prawidłowe wyniki, należy podawać **nieujemne liczby całkowite oddzielone spacjami**.

---

## 🧰 Technologie

* 💻 **PHP 7.1 lub nowszy** – język programowania wykorzystywany w projekcie.
* 🖥️ **PHP CLI** – uruchamianie programu w konsoli.
* 📥 **`readline()`** – pobieranie danych od użytkownika.
* 🔤 **`trim()` oraz `explode()`** – przygotowywanie tekstu wejściowego.
* 🛡️ **`array_filter()` oraz `is_numeric()`** – filtrowanie elementów wejściowych.
* 🔄 **`array_map()` oraz `intval()`** – konwersja wartości na liczby całkowite.
* 🔍 **`max()`** – wyszukiwanie największej wartości w tablicy.
* 🧮 **`array_fill()`** – tworzenie tablicy liczników.
* 📊 **`array_keys()`** – pobieranie indeksów wartości występujących w tablicy liczników.
* 🔁 **`foreach`, `for` oraz `while`** – zliczanie wystąpień i budowanie posortowanego wyniku.
* 📦 **Tablice PHP** – przechowywanie danych wejściowych, liczników i wyników sortowania.
* 🧠 **Counting Sort** – algorytm sortowania przez zliczanie.