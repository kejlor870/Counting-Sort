# 📊 Counting Sort w PHP

Implementacja algorytmu **Counting Sort (sortowania przez zliczanie)** w języku PHP. Projekt umożliwia sortowanie liczb całkowitych w kolejności rosnącej oraz uzyskanie dwóch wyników: tablicy zawierającej wszystkie wystąpienia liczb i tablicy z unikalnymi wartościami.

## ✨ Funkcjonalności

- 🔢 Sortowanie liczb całkowitych w kolejności rosnącej.
- ➖ Obsługa liczb ujemnych, zera oraz liczb dodatnich.
- 🔁 Zachowywanie duplikatów w pełnym wyniku sortowania.
- ✅ Zwracanie posortowanej tablicy bez duplikatów.
- 📦 Zwracanie obu wyników przez jedną funkcję `countingSort()`.
- 🛡️ Obsługa pustej tablicy wejściowej.
- 🧪 Testy jednostkowe wykorzystujące PHPUnit.
- 💻 Możliwość uruchomienia programu konsolowego za pomocą PHP CLI.

## 📁 Struktura projektu

```text
PHP/
├── main.php
├── countingSort.php
└── CountingSortTests.php
```

**`main.php`** — odpowiada za obsługę programu konsolowego.

**`countingSort.php`** — zawiera implementację funkcji `countingSort()`, która sortuje przekazane liczby i zwraca dwa wyniki.

**`CountingSortTests.php`** — zawiera testy jednostkowe sprawdzające poprawność działania algorytmu.

## 🚀 Wymagania i uruchomienie

### Wymagania

- PHP z obsługą PHP CLI.
- Terminal lub konsola.
- PHPUnit do uruchamiania testów jednostkowych.

Do samego działania funkcji sortującej nie są wymagane dodatkowe biblioteki zewnętrzne.

### Pobranie projektu

Sklonuj repozytorium:

```bash
git clone https://github.com/kejlor870/Counting-Sort.git
```

Przejdź do katalogu PHP:

```bash
cd Counting-Sort/PHP
```

Sprawdź, czy PHP jest zainstalowane:

```bash
php -v
```

### Uruchomienie programu

Aby uruchomić program konsolowy, wykonaj:

```bash
php main.php
```

Jeżeli program korzysta z interaktywnego wprowadzania danych, wpisz liczby oddzielone spacjami i zatwierdź je klawiszem `Enter`.

## 💡 Przykłady działania

### 1. Sortowanie liczb dodatnich

**Dane wejściowe:**

```php
[5, 2, 9, 2, 7, 5, 1]
```

**Posortowana tablica z duplikatami:**

```php
[1, 2, 2, 5, 5, 7, 9]
```

**Posortowana tablica bez duplikatów:**

```php
[1, 2, 5, 7, 9]
```

### 2. Sortowanie liczb ujemnych i dodatnich

**Dane wejściowe:**

```php
[2, 1, -2, 4, -5, 2]
```

**Posortowana tablica z duplikatami:**

```php
[-5, -2, 1, 2, 2, 4]
```

**Posortowana tablica bez duplikatów:**

```php
[-5, -2, 1, 2, 4]
```

### 3. Obsługa powtarzających się liczb ujemnych

**Dane wejściowe:**

```php
[-5, -5, -5, -1, -3]
```

**Posortowana tablica z duplikatami:**

```php
[-5, -5, -5, -3, -1]
```

**Posortowana tablica bez duplikatów:**

```php
[-5, -3, -1]
```

### 4. Tablica zawierająca wyłącznie zera

**Dane wejściowe:**

```php
[0, 0, 0]
```

**Wynik pełny:**

```php
[0, 0, 0]
```

**Wynik bez duplikatów:**

```php
[0]
```

### 5. Pusta tablica

**Dane wejściowe:**

```php
[]
```

**Wynik:**

```php
[
    [],
    []
]
```

Jeżeli do funkcji zostanie przekazana pusta tablica, algorytm zwróci dwie puste tablice.

## 🧮 Jak działa Counting Sort?

Funkcja `countingSort($numbers)` sortuje liczby, zliczając wystąpienia poszczególnych wartości zamiast porównywać ze sobą elementy tablicy.

Algorytm działa w następujących krokach:

1. **Sprawdzenie tablicy wejściowej** — jeżeli tablica jest pusta, funkcja zwraca `[[], []]`.
2. **Wyznaczenie zakresu liczb** — funkcje `min()` i `max()` określają najmniejszą i największą wartość.
3. **Utworzenie tablicy liczników** — `array_fill()` tworzy tablicę wypełnioną zerami. Jej rozmiar zależy od zakresu sortowanych wartości.
4. **Zliczanie wystąpień** — pętla `foreach` zwiększa odpowiedni licznik dla każdej liczby z wejścia.
5. **Tworzenie tablicy unikalnych wartości** — `array_filter()` wybiera liczniki o niezerowych wartościach, `array_keys()` pobiera odpowiadające im indeksy, a `array_map()` przekształca indeksy z powrotem na liczby.
6. **Tworzenie pełnego wyniku sortowania** — pętle `for` i `while` dodają każdą wartość do wyniku tyle razy, ile wynosi jej licznik.
7. **Zwrócenie wyników** — funkcja zwraca tablicę zawierającą pełny wynik sortowania i wynik bez duplikatów.

### Obsługa liczb ujemnych

Aby umożliwić sortowanie liczb ujemnych, algorytm przesuwa indeksy tablicy liczników o najmniejszą wartość wejściową.

Zliczanie wystąpień odbywa się za pomocą instrukcji:

```php
$countArr[$number - $minNumber]++;
```

Dzięki temu również liczby ujemne mogą być reprezentowane przez indeksy tablicy zaczynające się od zera.

Przy odtwarzaniu wyniku algorytm dodaje `minNumber` do indeksu, odzyskując pierwotną wartość liczby.

### Zwracane wartości

Funkcja `countingSort()` zwraca tablicę zawierającą dwa elementy:

```php
return [$sortedArr, $sortedWODuplications];
```

Pierwszy element to posortowana tablica ze wszystkimi duplikatami. Drugi element to posortowana tablica zawierająca każdą występującą wartość tylko raz.

Wyniki można odebrać na przykład za pomocą `list()`:

```php
list($sorted, $unique) = countingSort($numbers);
```

## 🧪 Testy jednostkowe

Projekt zawiera testy napisane z wykorzystaniem **PHPUnit**. Ich zadaniem jest sprawdzenie, czy funkcja `countingSort()` zwraca oczekiwane wyniki dla różnych rodzajów danych wejściowych.

Testy znajdują się w pliku `CountingSortTests.php`.

### Zakres testów

| Metoda testowa | Sprawdzana funkcjonalność |
|---|---|
| `testSortPositiveNumbers()` | Sortowanie liczb dodatnich, zachowanie duplikatów i poprawność tablicy unikalnych wartości. |
| `testSortingNegativeAndPositiveNumbers()` | Sortowanie liczb ujemnych i dodatnich w jednej tablicy. |
| `testEmptyArraySupport()` | Obsługa pustej tablicy wejściowej. |
| `testArrayWithOnlyZeros()` | Poprawne sortowanie tablicy zawierającej wyłącznie zera. |
| `testSupportDuplicatedNegativeNumbers()` | Zachowanie duplikatów liczb ujemnych i tworzenie wyniku bez duplikatów. |

Łącznie plik zawiera **5 testów jednostkowych**.

### Jak uruchomić testy?

Najpierw upewnij się, że PHP i PHPUnit są zainstalowane.

Jeżeli PHPUnit jest zainstalowany lokalnie w projekcie przez Composer, uruchom testy z katalogu `PHP` poleceniem:

```bash
./vendor/bin/phpunit CountingSortTests.php
```

W systemie Windows możesz użyć:

```bash
vendor\bin\phpunit CountingSortTests.php
```

Jeżeli PHPUnit jest dostępny globalnie, użyj:

```bash
phpunit CountingSortTests.php
```

Powyższe polecenia zakładają, że odpowiedni plik wykonywalny PHPUnit jest dostępny w danym środowisku.

### Oczekiwany rezultat

Jeżeli wszystkie testy przejdą pomyślnie, PHPUnit zgłosi pięć udanych testów i nie wyświetli błędów asercji.

Testy wykorzystują `PHPUnit\Framework\TestCase` oraz metodę `assertEquals()` do porównywania rzeczywistych wyników sortowania z wynikami oczekiwanymi.

## ⏱️ Złożoność obliczeniowa

Niech:

- `n` — liczba elementów tablicy wejściowej;
- `k` — zakres sortowanych wartości, czyli `maxNumber - minNumber + 1`.

Złożoność algorytmu przedstawia się następująco:

| Rodzaj złożoności | Wartość |
|---|---|
| Czasowa | `O(n + k)` |
| Pamięciowa | `O(n + k)` |

Złożoność czasowa uwzględnia zliczanie elementów, filtrowanie tablicy liczników i budowanie wyników sortowania.

Złożoność pamięciowa wynika z przechowywania danych wejściowych, tablicy liczników i tablic wynikowych.

Counting Sort jest szczególnie efektywny, gdy liczba elementów jest duża, a zakres sortowanych wartości stosunkowo niewielki.

W przypadku bardzo dużego zakresu wartości tablica liczników może jednak wymagać znacznej ilości pamięci.

## ⚠️ Ograniczenia

- Funkcja jest przeznaczona do sortowania liczb całkowitych.
- Funkcja nie wykonuje pełnej walidacji typów i wartości wszystkich elementów tablicy wejściowej.
- Wartości zmiennoprzecinkowe nie są jawnie odrzucane. Nie należy traktować ich jako prawidłowych danych wejściowych dla tej implementacji.
- Pamięć wymagana przez tablicę liczników zależy od zakresu między najmniejszą a największą wartością, a nie tylko od liczby elementów.
- Testy jednostkowe wymagają zainstalowanego PHPUnit.
- Program konsolowy i sama funkcja sortująca pełnią różne role: program obsługuje użytkownika, a funkcja wykonuje sortowanie przekazanej tablicy.

## 🛠️ Technologie

- **PHP** — język programowania wykorzystany do implementacji algorytmu.
- **PHP CLI** — uruchamianie programu konsolowego.
- **PHPUnit** — testy jednostkowe.
- **Counting Sort** — algorytm sortowania przez zliczanie.
- **Tablice PHP** — przechowywanie danych wejściowych, liczników i wyników.
- **Funkcje standardowe PHP** — m.in. `min()`, `max()`, `array_fill()`, `array_filter()`, `array_keys()` i `array_map()`.

## 📚 Cel projektu

Celem projektu jest przedstawienie działania algorytmu Counting Sort w języku PHP, w tym zliczania wystąpień liczb, obsługi duplikatów, sortowania liczb ujemnych oraz testowania poprawności implementacji za pomocą PHPUnit.
