void randomFillArray(int[] array) {
    var r = new Random();
    for (int i = 0; i < array.length; i++) {
        array[i] = r.nextInt(-10, 11);
    }
}

void increaseFillArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
        array[i] = i;
    }
}

void main() {
    int[] data1 = new int[10000];
    randomFillArray(data1);
    int[] data2 = Arrays.copyOf(data1, data1.length);
    System.out.println("До сортировки: " + Arrays.toString(data1));
    var bCnt = bubbleSort(data1);
    System.out.println("После сортировки пузырьком: " + Arrays.toString(data1));
    System.out.println("Количество итераций: " + bCnt);
    var sCnt = shakerSort(data2);
    System.out.println("После шейкерной сортировки: " + Arrays.toString(data2));
    System.out.println("Количество итераций: " + sCnt);

}
int bubbleSort(int[] array){
    if (array == null || array.length < 2) return 0;
    int cnt = 0;
    for (int i = 0; i < array.length; i++){
        for (int j = 0; j < array.length - 1; j++){
            cnt++;
            if (array[j] > array[j + 1]){
                swap(array, j, j + 1);
                //cnt++;
            }
        }
    }
    return cnt;
}

int shakerSort(int[] array){
    if (array == null || array.length < 2) return 0;
    int cnt = 0;
    int left = 0;
    int right = array.length - 1;
    boolean swapped = false;
    do {
        for (int i = left; i < right; i++) {
            if (array[i] > array[i+1]) {
                swap(array, i, i+1);
                swapped = true;
            }
            cnt++;
        }
        if (! swapped) break;
        right--;
        swapped = false;
        for (int i = right; i > left; i--){
            if (array[i] < array[i-1]){
                swap(array, i, i-1);
                swapped = true;
            }
            cnt++;
        }
        left++;
    } while(left < right && swapped);
    return cnt;
}
void swap(int[] array, int i, int j) {
    int t = array[i];
    array[i] = array[j];
    array[j] = t;
}
