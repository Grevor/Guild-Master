package org.staticvoid.gm.input;

public class IOUtil {
	private static final String headerStart = "###############\n#####";
	private static final String headerEnd = "#####\n###############";
	public static void decorateAsHeader(String s, GameIO io) {
		io.println(headerStart);
		io.println(s);
		io.println(headerEnd);
	}
	
	public static boolean isIn(int start, int end, int ans) { return start <= ans && ans <= end; }
}
