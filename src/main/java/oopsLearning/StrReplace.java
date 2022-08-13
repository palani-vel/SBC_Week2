package oopsLearning;

public class StrReplace {
	public static void main(String[] args) {
		String str = "(996) 216-5493";
		str = str.replace("(", "");
		str = str.replace(")", "");
		str = str.replace("-", "");
		str = str.replaceAll(" ", "");
		System.out.println(str);
	}

}
