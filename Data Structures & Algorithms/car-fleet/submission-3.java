class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];

        for(int i = 0; i<position.length; i++)
        {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target-position[i])/speed[i]; 
        }

        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0]));
        Stack<Double> st = new Stack<>();

        
        for(int i = 0; i<position.length; i++)
        {
            double currentTime = cars[i][1];
            if(st.isEmpty() || currentTime > st.peek())
            {
                st.push(currentTime);
            }
        }

        return st.size();
    }
}
