package string.unicode;

import java.lang.Character.UnicodeBlock;
import java.nio.charset.Charset;
import java.util.stream.IntStream;

public class UnicodeIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 Exercise 1

		 印出自己的名字其中一個字的UTF-8編碼的bytes值。(不要給我用英文名去印)
			例如：
			
			潤
			
			E6 BD A4
		 */
		System.out.print("-------Answer1: ");
		printBytes("凡");
		 
		
		
		 
		
		 
		
		 
		
		 
		/*
		Exercise 2
		
		印出自己的名字其中一個字的Big5編碼的bytes值。(不要給我用英文名去印)
		
		 
		
		例如：
		
		潤
		
		BC ED
		*/
		System.out.print("-------Answer2: ");
		printBytes("凡", "BIG5");
		/*
		
		 
		
		 
		
		 
		
		 
		
		Exercise 3
		
		印出自己的名字其中一個字的unicode code point值。(不要給我用英文名去印)
		
		 
		
		例如：
		
		潤
		
		28516
		*/
		String name = "高逸凡";
		StringBuilder sb = new StringBuilder("-------Answer3:");
//		int codePointAt = name.codePointAt(0);
		for (int i = 0; i < name.length(); i++) {
			int codePointAt = Character.codePointAt(name, i);
			sb.append(" ").append(codePointAt);	
		}
		System.out.println(sb.toString());
		/*
		
		 
		
		 
		
		 
		
		 
		
		 
		
		 
		
		Exercise 4
		
		"\u597D"這是什麼字?  
		*/
//		String u597D = new String("\u597D");
		
		System.out.println("-------Answer4: \u597D");	//high-Surrogate
		
		System.out.print("addition codePointAt: " + Character.codePointAt("严", 0));
		System.out.print("\n\t isDigit: " + Character.isDigit('1'));	//是否為數字
		System.out.print("\n\t isLetter: " + Character.isLetter('\uD840'));
		System.out.println("\n\t isSurrogate: " + Character.isSurrogate('\uD840'));
		
		/*
		Exercise 5
		
		請用Java的API，判斷注音符號ㄅㄆㄇ，是不是中文。
		*/
		StringBuilder answer5 = new StringBuilder("-------Answer 5: \n");
		String bpm = "ㄅㄆㄇ";
		for(char c : bpm.toCharArray()) {
			UnicodeBlock of = Character.UnicodeBlock.of(c);
			if(of == UnicodeBlock.BOPOMOFO) {
				answer5.append(c + "是注音文：\n");
			}
		}
		answer5.append("漢語注音(3105-312F) 的 unicode character block 為 BOPOMOFO \n")
			.append("\t是否為中文端看中文(漢字)的定義");
		System.out.println(answer5);
		
		 
		
		 
		
		 
		
		 
		
		 
		
		 
		
		 
		/*
		Exercise 6
		
		UTF-8跟UTF-16，分別最多可能會有幾個bytes?
		
		這個大家自己去google看看。
		
		 */
		System.out.print("-------Answer6:\n");
		System.out.print("\t UTF-8 最多6個Bytes");
		System.out.print("\t UTF-16 最多X個Bytes");
		/* ----------------------------------------------------------------------------------------------------------
		 * https://zh.wikipedia.org/wiki/UTF-8
		   碼點的位數	碼點起值		碼點終值		位元組序列	Byte 1	 Byte 2	    Byte 3	 Byte 4	  Byte 5	   Byte 6
			 7		U+0000	 	U+007F		1			0xxxxxxx
			11		U+0080	 	U+07FF		2			110xxxxx	 10xxxxxx
			16		U+0800	 	U+FFFF		3			1110xxxx	 10xxxxxx	10xxxxxx
			21		U+10000	 	U+1FFFFF		4			11110xxx	 10xxxxxx	10xxxxxx	 10xxxxxx
			26		U+200000	 	U+3FFFFFF	5			111110xx	 10xxxxxx	10xxxxxx	 10xxxxxx  10xxxxxx
			31		U+4000000	U+7FFFFFFF	6			1111110x	 10xxxxxx	10xxxxxx	 10xxxxxx  10xxxxxx 10xxxxxx
			
		 * https://zh.wikipedia.org/wiki/UTF-16
		   16進制編碼範圍			UTF-16表示方法（二進制）				10進制碼範圍		位元組數量
			U+0000---U+FFFF		xxxxxxxx xxxxxxxx yyyyyyyy yyyyyyyy	0-65535			2
			U+10000---U+10FFFF	110110yyyyyyyyyy 110111xxxxxxxxxx	65536-1114111	4
		 * ----------------------------------------------------------------------------------------------------------	
		 */
	}
	
	
	
	
	private static void printBytes(String str, String encoding) {
		byte[] bytes = str.getBytes(Charset.forName(encoding));
		for (byte b : bytes) {
			System.out.print("utf-8 byte=" + String.format("%02X", b) + "\t");
		}
		System.out.print("\n");
	}
	private static void printBytes(String str) {
		printBytes(str, "UTF-8");
	}

}
