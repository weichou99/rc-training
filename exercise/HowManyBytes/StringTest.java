import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;

/**
 * JDK:1.7
 **/
public class StringTest {

	private static String s = "李";

	public static void main(String[] args) throws UnsupportedEncodingException {
		// Exercise 1 :印出自己的名字其中一個字的UTF-8編碼的bytes值。
		show("UTF-8");

		// Exercise 2 :印出自己的名字其中一個字的BIG5編碼的bytes值。
		show("BIG5");

		// Exercise 3 :印出自己的名字其中一個字的unicode code point值
		System.out.println(String.format("%s(CodePoint)：\n%s", s, s.codePointAt(0)));
		System.out.println(
				String.format("%s(UnionCode)：\n", s) + String.format("U+%02x", s.codePointAt(0)).toUpperCase());

		// Exercise 4 :"\u597D"這是什麼字?
		int[] codePoints = { Integer.parseInt("597D", 16) };
		System.out.println(new String(codePoints, 0, 1));

		//Exercise 5 :請用Java的API，判斷注音符號ㄅㄆㄇ，是不是中文
		String ch = "ㄅㄆㄇ＋";
		for (int i = 0; i < ch.length(); i++) {
			char c = ch.charAt(i);
			System.out.println(c + ":" + isChinese(c));
		}

	}

	public static void show(String ch) throws UnsupportedEncodingException {
		System.out.print(String.format("%s(%s)：\n", s, ch));
		for (byte b : s.getBytes(ch)) {
			System.out.print(String.format("%02x", b).toUpperCase() + " ");
		}
		System.out.println();
	}

	public static boolean isChinese(char s) {
		UnicodeBlock[] chinese_ubs = { UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A, // 中文A
				UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B, // 中文B
				UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C, // 中文C
				UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D, // 中文D
				UnicodeBlock.BOPOMOFO // 注音
		};
		UnicodeBlock ub = Character.UnicodeBlock.of(s);
		boolean flag = false;
		for (UnicodeBlock chinese_ub : chinese_ubs) {
			flag = flag || (ub == chinese_ub);
		}
		return flag;

	}

}
