class Solution {
    public int maximumSum(int[] arr) {
        	int n = arr.length;
		
		// sum when no deletion
		int preSum = arr[0];
		int currSum = arr[0];
		
		int maxSum = arr[0];
		
		for (int i = 1; i < n; i++) {
			
			if (preSum < 0) {
				
				currSum = arr[i];
				preSum = currSum;
			}
			else {
				currSum = preSum + arr[i];
				preSum = currSum;
			}
			
			maxSum = Math.max(maxSum, currSum);
		}
		
		// remove ek element
		
		int[] preSumArr = new int[n];
		int[] suffSumArr = new int[n];
		
		preSumArr[0] = arr[0];
		for (int i = 1; i < n; i++) {
			
			if (preSumArr[i - 1] >= 0)
				preSumArr[i] = preSumArr[i - 1]+arr[i];
			else
			    preSumArr[i] = arr[i];
		}
		
		suffSumArr[n-1] = arr[n-1];
		
		for(int i = n-2; i >= 0; i--){
		    
		    if(suffSumArr[i+1] >= 0)
		        suffSumArr[i] = suffSumArr[i+1]+arr[i];
		    else
		        suffSumArr[i] = arr[i];
		}
		
		for(int i = 1; i < n-1; i++){
		    
		    maxSum = Math.max(maxSum, preSumArr[i-1]+suffSumArr[i+1]);
		}
		
		return maxSum;

    }
}
