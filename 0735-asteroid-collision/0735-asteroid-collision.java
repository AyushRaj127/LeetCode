class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack <Integer> st = new Stack();

        for (int asteroid : asteroids) {
            boolean notCollide = true;

            while (notCollide && !st.isEmpty() && st.peek() > 0 && asteroid < 0) {
                if (st.peek() < -asteroid) {
                    st.pop();
                } else if (st.peek() == -asteroid) {
                    st.pop();
                    notCollide = false;
                } else {
                    notCollide = false;
                }
            }

            if (notCollide) {
                st.push(asteroid);
            }
        }

        int[] result = new int[st.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = st.get(i);
        }

        return result;
    }
}