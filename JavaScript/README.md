# 📊 Counting Sort w Node.js

Prosty program konsolowy napisany w **JavaScript (Node.js)**, który pobiera od użytkownika ciąg liczb, a następnie sortuje je za pomocą algorytmu **sortowania przez zliczanie (Counting Sort)**.

Program filtruje dane wejściowe, ignorując wartości, których nie można przekonwertować na liczby. Zwraca wynik w dwóch wariantach: pełną posortowaną tablicę, zawierającą duplikaty, oraz posortowaną tablicę bez powtarzających się wartości.

Projekt zawiera również testy jednostkowe sprawdzające poprawność działania algorytmu dla różnych danych wejściowych.

---

## ✨ Funkcje programu

- 📥 **Interaktywność** – pobiera dane bezpośrednio z konsoli.
- 🛡️ **Walidacja danych wejściowych** – usuwa wartości, które nie są poprawnymi liczbami, oraz obsługuje nadmiarowe spacje.
- 🔢 **Obsługa liczb dodatnich, ujemnych i zera** – algorytm uwzględnia zarówno liczby mniejsze, jak i większe od zera.
- 🎨 **Kolorowanie komunikatów w terminalu** – wykorzystuje kody ANSI do wyróżniania wybranych komunikatów.
- 🔄 **Dwa warianty wyniku**:
  - `SortedArray` – wszystkie liczby posortowane rosnąco, z zachowaniem duplikatów.
  - `SortedWithoutDuplications` – posortowane wartości bez duplikatów.
- 🧪 **Testy jednostkowe** – sprawdzają sortowanie liczb dodatnich i ujemnych, obsługę duplikatów, pustej tablicy oraz zer.
- 📦 **Możliwość ponownego wykorzystania funkcji** – funkcja `CountingSort` jest eksportowana przez `module.exports`, dzięki czemu można ją importować w innych plikach JavaScript.

---

## 📁 Struktura projektu

```text
JavaScript/
├── countingSort.js
├── countingSort.test.js
└── README.md
```

- `countingSort.js` – implementacja algorytmu i interfejs konsolowy.
- `countingSort.test.js` – testy jednostkowe algorytmu.
- `README.md` – dokumentacja projektu.

---

## 🚀 Jak uruchomić program

### Wymagania wstępne

Do uruchomienia projektu potrzebne jest środowisko **Node.js**. Zalecana jest wersja **18 lub nowsza**, która obsługuje wbudowany moduł `node:test`.

Projekt nie wymaga instalowania zewnętrznych bibliotek.

### Instrukcja krok po kroku

1. Sklonuj repozytorium lub pobierz pliki projektu.
2. Otwórz terminal w katalogu `JavaScript`.
3. Uruchom program poleceniem:

   ```bash
   node countingSort.js
   ```

4. Wpisz liczby oddzielone spacjami i zatwierdź klawiszem Enter.

---

## 💡 Przykład działania

Po uruchomieniu programu pojawi się prośba o podanie liczb.

**Dane wejściowe:**

```text
Podaj liczby do posortowania (rozdzielone spacjami): 5 2 9 2 7 5 1
```

**Przykładowy wynik:**

```text
| Podane przez ciebie liczby: 5 2 9 2 7 5 1
|--------------------------------------
| Posortowane liczby: 1 2 2 5 5 7 9
| Posortowane liczby bez duplikatów: 1 2 5 7 9
```

Jeżeli program nie otrzyma poprawnych danych wejściowych, wyświetli komunikat:

```text
Nie podano poprawnych liczb.
```

**Uwaga:** algorytm Counting Sort jest przeznaczony do sortowania liczb całkowitych. W przypadku wartości niecałkowitych należy odpowiednio rozszerzyć walidację danych wejściowych.

---

## 🧪 Testy jednostkowe

Projekt wykorzystuje wbudowany moduł `node:test` oraz moduł `assert/strict` do sprawdzania poprawności wyników.

### Uruchamianie testów

W terminalu, w katalogu `JavaScript`, wykonaj polecenie:

```bash
node --test countingSort.test.js
```

Testy można również uruchomić poleceniem:

```bash
node --test
```

Drugie polecenie uruchamia testy wykryte przez wbudowany mechanizm testowy Node.js.

### Zakres testów

Plik `countingSort.test.js` zawiera sześć testów:

1. **Sortowanie liczb dodatnich** – sprawdza, czy liczby zostają ułożone rosnąco.
2. **Sortowanie liczb dodatnich i ujemnych** – sprawdza poprawność sortowania wartości po obu stronach zera.
3. **Usuwanie duplikatów** – sprawdza, czy `SortedWithoutDuplications` zawiera tylko unikalne wartości.
4. **Obsługa pustej tablicy** – sprawdza zachowanie funkcji dla `[]`.
5. **Obsługa samych zer** – sprawdza zachowanie obu wyników dla tablicy `[0, 0, 0]`.
6. **Obsługa powtarzających się liczb ujemnych** – sprawdza sortowanie i usuwanie duplikatów dla powtarzających się wartości ujemnych.

Testy nie wymagają instalowania dodatkowych pakietów.

---

## 🛠️ Szczegóły techniczne algorytmu

### Funkcja `CountingSort(array)`

Funkcja przyjmuje tablicę liczb i sortuje jej elementy za pomocą tablicy zliczeń.

**Sposób działania:**

1. Sprawdza, czy tablica wejściowa jest pusta. Jeśli tak, zwraca pustą tablicę `[]`.
2. Wyznacza najmniejszą oraz największą wartość w tablicy.
3. Tworzy tablicę zliczeń obejmującą cały zakres wartości od minimum do maksimum.
4. Zlicza wystąpienia poszczególnych liczb.
5. Tworzy tablicę unikalnych wartości na podstawie liczby wystąpień.
6. Odtwarza pełną posortowaną tablicę, uwzględniając liczbę wystąpień każdej wartości.
7. Zwraca obiekt z dwoma tablicami wynikowymi.

### Wartość zwracana

Dla niepustej tablicy funkcja zwraca obiekt o następującej strukturze:

```javascript
{
    SortedArray: [...],
    SortedWithoutDuplications: [...]
}
```

- `SortedArray` – tablica wszystkich liczb posortowanych rosnąco, z zachowaniem duplikatów.
- `SortedWithoutDuplications` – tablica posortowanych, unikalnych wartości.

**Ważne:** dla pustej tablicy funkcja zwraca bezpośrednio `[]`, a nie obiekt z powyższymi właściwościami.

### Przykład użycia funkcji

Funkcję można zaimportować i wykorzystać niezależnie od interfejsu konsolowego:

```javascript
const CountingSort = require('./countingSort');

const result = CountingSort([4, -2, 7, -5, 0, 2, -2]);

console.log(result.SortedArray);
// [-5, -2, -2, 0, 2, 4, 7]

console.log(result.SortedWithoutDuplications);
// [-5, -2, 0, 2, 4, 7]
```

---

## ⏱️ Złożoność algorytmu

Oznaczenia:

- \(n\) – liczba elementów tablicy wejściowej.
- \(k\) – zakres wartości, czyli różnica między największą i najmniejszą liczbą powiększona o jeden.

| Rodzaj złożoności | Wartość |
|---|---|
| Czasowa | \(O(n + k)\) |
| Pamięciowa | \(O(n + k)\) |

Złożoność zależy nie tylko od liczby elementów, ale również od zakresu sortowanych wartości. Jeżeli zakres \(k\) jest bardzo duży w porównaniu z liczbą elementów \(n\), utworzenie tablicy zliczeń może wymagać znacznej ilości pamięci.

---

## 📌 Wykorzystane technologie

- **JavaScript** – implementacja algorytmu.
- **Node.js** – środowisko uruchomieniowe.
- **`node:readline/promises`** – odczytywanie danych wprowadzanych przez użytkownika.
- **`node:test`** – wbudowany moduł do testów jednostkowych.
- **`assert/strict`** – weryfikacja wyników testów.

---

## 📝 Podsumowanie

Projekt przedstawia implementację algorytmu Counting Sort w JavaScript, wraz z interaktywnym interfejsem konsolowym i testami jednostkowymi.

Umożliwia sortowanie liczb całkowitych, w tym ujemnych, oraz uzyskanie dwóch wariantów wyniku: z duplikatami i bez nich. Testy pomagają sprawdzić poprawność działania funkcji dla najważniejszych przypadków wejściowych.
