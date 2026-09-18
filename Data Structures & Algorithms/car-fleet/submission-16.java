class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];

        for(int i = 0; i<position.length; i++)
        {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (c1, c2) -> Double.compare(c2[0], c1[0]));

        Stack<Double> st = new Stack<>();

        for(int i = 0; i<cars.length; i++)
        {
            double t = cars[i][1];

            if(st.isEmpty() || st.peek() < t)
            {
                st.push(t);
            }
        }

        return st.size();
    }
}
