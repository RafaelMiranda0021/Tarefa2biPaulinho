
package br.unipar.tarefa_paulino;

import java.util.Scanner;


public class Tarefa_paulino {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a quantidade de números a serem inseridos: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        
        System.out.println("Digite os números:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        bubbleSort(numbers);
        
        System.out.println("Lista ordenada:");
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        
        System.out.print("Digite o número a ser pesquisado na lista ordenada: ");
        int searchNumber = scanner.nextInt();
        
        int position = linearSearch(numbers, searchNumber);
        if (position != -1) {
            System.out.println("O número " + searchNumber + " está presente na posição " + (position + 1) + " da lista ordenada.");
        } else {
            System.out.println("O número " + searchNumber + " não está presente na lista ordenada.");
        }
        
        scanner.close();
    }
   
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    private static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; 
            }
        }
        return -1; 
    }
}
