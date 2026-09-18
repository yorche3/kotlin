// NaiveSort — ordenamientos elementales O(n²).
//
// Especificación: 05_Naive_Sort
//
// Contrato de las funciones (IntArray? -> IntArray?), de menor a mayor:
//   selectionSort: encuentra el mínimo del tramo no ordenado y lo ubica al inicio.
//   bubbleSort:    compara e intercambia adyacentes, con bandera `swapped`.
//   insertionSort: inserta cada elemento en su sub-array ordenado.
//
// Caso nulo: en Kotlin `IntArray?` admite `null`, así que el indicador de fallo es
// devolver `null` cuando la entrada es `null`, sin lanzar excepciones.

package naive_sort

object NaiveSort
