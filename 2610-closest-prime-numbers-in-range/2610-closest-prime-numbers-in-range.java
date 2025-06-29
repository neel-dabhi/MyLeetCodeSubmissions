class Solution {
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        int i = left;
        if (left == 1) {
            i = 2;
        }

        for (; i <= right; i++) {
            if (isPrime(i)) {

                primes.add(i);
            }
        }

        int[] primeArray = new int[primes.size()];

        for (int j = 0; j < primes.size(); j++) {
            primeArray[j] = primes.get(j);
        }

        int diffrence = 10000000;
        int a = 0;
        int b = 0;
        
        for(int j = primeArray.length -1; j>=1; j--){
            if(diffrence >= primeArray[j] - primeArray[j-1]){
                diffrence = primeArray[j] - primeArray[j-1];
                a = primeArray[j-1];
                b = primeArray[j];
            }
        }

        if(a==0 && b==0){
            a= -1;
            b= -1;
        }

        return new int[] { a, b };
    }

    public boolean isPrime(int a) {
        if (a <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }

        return true;
    }

}