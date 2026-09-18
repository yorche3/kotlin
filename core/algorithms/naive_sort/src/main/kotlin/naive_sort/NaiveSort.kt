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

object NaiveSort {
    fun selectionSort(arr: IntArray?): IntArray? {
        if (arr == null) return null
        val n = arr.size
        if (n <= 1) return arr
        for (i in 0 until n - 1) {
            var minIndex = i
            for (j in i + 1 until n) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j
                }
            }
            if (minIndex != i) {
                val temp = arr[i]
                arr[i] = arr[minIndex]
                arr[minIndex] = temp
            }
        }
        return arr
    }

    fun bubbleSort(arr: IntArray?): IntArray? {
        if (arr == null) return null
        val n = arr.size
        if (n <= 1) return arr
        for (i in 0 until n - 1) {
            var swapped = false
            for (j in 0 until n - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                    swapped = true
                }
            }
            if (!swapped) break
        }
        return arr
    }

    fun insertionSort(arr: IntArray?): IntArray? {
        if (arr == null) return null
        val n = arr.size
        if (n <= 1) return arr
        for (i in 1 until n) {
            val key = arr[i]
            var j = i - 1
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]
                j--
            }
            arr[j + 1] = key
        }
        return arr
    }
}
