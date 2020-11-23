//https://leetcode.com/problems/bulls-and-cows/
class Solution{
    public String getHint(String secret, String guess) {
        int a = 0;
		int b = 0;
		int[] arr = new int[10];

		for (char c : secret.toCharArray()) {
			arr[c - '0'] += 1;
		}

		for (int i = 0; i < guess.length(); i++) {
            char s=secret.charAt(i);
            char g=guess.charAt(i);
			int num = g - '0';
			if (arr[num] > 0 && s == g) {
				a++;
				arr[num] -= 1;
			}
		}

		for (int i = 0; i < guess.length(); i++) {
			char s=secret.charAt(i);
            char g=guess.charAt(i);
			int num = g - '0';
			if (arr[num] > 0 && s!= g) {
				b++;
				arr[num] -= 1;
			}
		}

        StringBuilder sb=new StringBuilder();
        sb.append(a).append("A").append(b).append("B");
        return sb.toString();
    }
}