//Create a function that takes an array of integers, sums the even and odd numbers separately, 
//then returns the difference between the sum of the even and odd numbers

class warOfNumbersChallenge {
    public static void main(String[] args) {
        int[] numbers = {2, 8, 7, 5}; //set number in the array
        System.out.println(warOfNumbers(numbers)); //output warOfNumbers method
    }
//start of warOfNumbers method    
    public static int warOfNumbers(int[] numbers) {
        int evenSum = 0;//This is where we will store an array of even numbers
        int oddSum = 0;//This is where we will store an array of odd numbers

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenSum += numbers[i];//add even number to evenSum array
            } else {
                oddSum += numbers[i];//add odd number to oddSum array
            }
        }
    return Math.abs(evenSum - oddSum);//return the difference between evenSum and oddSum arrays
    }
}
