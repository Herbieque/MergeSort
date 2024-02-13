package MergeSort;
import java.util.Random; 
import java.util.Scanner; 
public class MergeSort {

    public static int[] createRandomArray(int arrayLength) {  
        Random randomnumbers = new Random();  
        int[] array = new int[arrayLength]; 
        for (int i = 0; i < arrayLength; i++) {
            array[i] = randomnumbers.nextInt(101); 
            
        }
        
        return array;  
    } 

    public static void bubbleSort(int[] array){
        int[] swap = new int[array.length]; 
        for (int i = 0; i < array.length; i++){
            for (int h = i+1; h < array.length; h++){
                if (array[i] > array[h]){
                    swap[h] = array[i];
                    array[i] = array[h]; 
                    array[h] = swap[h]; 
                }
            }
        }
            for (int k = 0; k < array.length; k++){
                System.out.print(array[k] + " "); 
            }
    }

  

  public static void merge(int array[], int left, int mid, int right) {

      
        int num1 = mid - left + 1;
        int num2 = right - mid;
      
       
        int Left[] = new int[num1];
        int Right[] = new int[num2];
      
       
        for (int i = 0; i < num1; ++i) {
          Left[i] = array[left+ i];
        }
      
        for (int j = 0; j < num2; ++j) {
          Right[j] = array[mid + 1 + j];
        }
      
       
        int i = 0;
        int j = 0; 
        int k = left; 
      
        while (i < num1 && j < num2) {
      
          if (Left[i] <= Right[j]) {
      
            array[k] = Left[i];
            i++;
          } else {
      
            array[k] = Right[j];
            j++;
          }
      
          k++;
        }
      
        
        while (i < num1) {
      
          array[k] = Left[i];
          i++;
          k++;
        }
      
        
        while (j < num2) {
      
          array[k] = Right[j];
          j++;
          k++;
        }
      }
    
      public static void sort(int array[], int left, int right) {

        if (left< right) {
      
          int mid = (left + right) / 2; 
          sort(array, left, mid); 
          sort(array, mid + 1, right); 
          merge(array, left, mid, right); 
        }
          
      }

  
    public static void main(String[] args) {
      long startTime = System.currentTimeMillis();
        Scanner input = new Scanner(System.in);
        System.out.println("Make a selection\n1.Bubble Sort\n2.Merge Sort");  
        int selection = input.nextInt();   

        if (selection == 1){
          System.out.print("Enter the length of the array: ");
          int length = input.nextInt(); 
           int array2[] = createRandomArray(length); 
            System.out.print("\nThe sorted array is: ");
            bubbleSort(array2);         
        }  
        if (selection == 2){
             System.out.print("Enter the length of the array: ");  
            int length = input.nextInt(); 
            int array3[] = createRandomArray(length);   
        System.out.print("\nThe sorted array is: ");
        sort(array3, 0, array3.length-1); 
        for (int i = 0; i < array3.length; i++){
            System.out.print(array3[i] + " ");
        }
        input.close(); 
        }

        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime; 
        System.out.println("\nTotal runtime in seconds:" + (runTime/1000)); 
    }
}


