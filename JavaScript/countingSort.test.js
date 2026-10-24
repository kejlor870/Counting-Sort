const test = require('node:test');
const assert = require('assert/strict');

const CountingSort = require('./countingSort');

test('sortuje liczby dodatnie', () => {
    assert.deepStrictEqual(
        CountingSort([5, 2, 8, 1]).SortedArray,
        [1, 2, 5, 8]
    );
});

test('sortuje liczby dodatnie i ujemne', () => {
    assert.deepStrictEqual(
        CountingSort([4, -2, 7, -5, 0, 2, -2]).SortedArray,
        [-5, -2, -2, 0, 2, 4, 7]
    );
});

test('usuwa duplikaty w SortedWithoutDuplications', () => {
    assert.deepStrictEqual(
        CountingSort([3, 1, 3, 2, 1]).SortedWithoutDuplications,
        [1, 2, 3]
    );
});

test('obsluguje pusta tablice', () => {
    assert.deepStrictEqual(
        CountingSort([]),
        []
    );
});

test('obsluguje same zera', () => {
    const result = CountingSort([0, 0, 0]);

    assert.deepStrictEqual(result.SortedArray, [0, 0, 0]);
    assert.deepStrictEqual(result.SortedWithoutDuplications, [0]);
});

test('obsluguje powtarzajace sie liczby ujemne', () => {
    const result = CountingSort([-3, -3, -1, -3]);

    assert.deepStrictEqual(result.SortedArray, [-3, -3, -3, -1]);
    assert.deepStrictEqual(result.SortedWithoutDuplications, [-3, -1]);
});