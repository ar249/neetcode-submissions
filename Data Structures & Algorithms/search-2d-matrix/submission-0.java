class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int l = 0;
        int r = matrix[0].length-1;

        for(int[] arr : matrix)
        {
            if(arr[l] == target || arr[r] == target)
            {
                return true;
            }
            if(arr[l]<target && arr[r]>target)
            {
                int idx = getIdx(arr, target);
                return idx == -1 ? false : true;
            }
            else {
                continue;
            }
        }

        return false;
    }

    private int getIdx(int[] matrix, int target)
    {
        int l = 0;
        int r = matrix.length-1;

        while(l<=r)
        {
            int mid = l + (r-l)/2;
            if(matrix[mid] == target)
            {
                return mid;
            }
            else if(matrix[mid] > target)
            {
                r = mid-1;
            }
            else
            {
                l = mid+1;
            }
        }

        return -1;
    }
}
