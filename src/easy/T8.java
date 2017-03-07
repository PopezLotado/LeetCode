package easy;

public class T8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T8 t8 = new T8();
		System.out.println(t8.myAtoi("123456789012345678901234567890"));
	}

	public int myAtoi(String str) {
		char[] s = str.trim().toCharArray();
		if (s.length == 0)
			return 0;
		boolean negative = false;
		int start = 0;
		int multmin = Integer.MIN_VALUE / 10;
		int limit = -1 * Integer.MAX_VALUE;
		if (s[0] == '-') {
			if (s.length == 1)
				return 0;
			negative = true;
			limit = Integer.MIN_VALUE;
			start = 1;
		} else if (s[0] == '+') {
			if (s.length == 1)
				return 0;
			start = 1;
		}
		int res = 0;
		for (int i = start; i < s.length; i++) {
			if (s[i] >= '0' && s[i] <= '9') {
				if (res < multmin)
					return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				res = res * 10;
				int digit = s[i] - '0';
				if (res < limit + digit)
					return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				res -= digit;
			} else
				return negative ? res : -1 * res;
		}
		return negative ? res : -1 * res;
	}
}
