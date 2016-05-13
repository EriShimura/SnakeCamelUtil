package snakecamel;

public class SnakeCamelUtil {

	public static String snakeToCamelcase(String snake_case) {
		String[] words = snake_case.split("_");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			sb.append(capitalize(words[i]));
		}
		return new String(sb);
	}
	 
	public static String camelToSnakecase(String camelCase) {
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for (int i = 0; i < camelCase.length(); i++) {
			char c = camelCase.charAt(i);	// 今見てる文字が
			if (Character.isUpperCase(c)) {	// 大文字だったら
				sb.append(camelCase.substring(j, i));	// 前に大文字だったとこから今の地点までを+して
				if (sb.length() > 0) {	// 一番はじめの大文字でなければ、
					sb.append("_");		// _を追加して
				}
				sb.append(Character.toLowerCase(c));	// 最後に感知した大文字を小文字になおして+する
				j = i + 1;	// jの位置訂正
			}
		}
		sb.append(camelCase.substring(j));
		return new String(sb);
	}
	
	static String capitalize(String s) {
		char first = s.charAt(0);
		char upperFirst = Character.toUpperCase(first);
		String rest = s.substring(1);
		return upperFirst + rest;
	}

	static String uncapitalize(String s) {
		char first = s.charAt(0);
		char lowerFirst = Character.toLowerCase(first);
		String rest = s.substring(1);
		return lowerFirst + rest;
	}
}
