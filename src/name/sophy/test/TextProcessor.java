package name.sophy.test;
/*
 * 20180921 ThoughtWork作业题
 * (1)
 * The main theme of education in
 *  engineering school is learnin
 * g to teach yourself
 * 
 * The(1); (1);main(1); (1);theme(1); (1);of(1); (1);education(1); (1);in(1);
 *  (2);engineering(2); (2);school(2); (2);is(2); (2);
 *  learning(2,3); (3);to(3); (3);teach(3); (3);yourself(3);
 */
public class TextProcessor {
	public String process(String text, int width) {
		if(width < 10 || width > 80)			//illegal input
			return 	"ERROR: Width out of range!";
		
		StringBuilder sBuilder = new StringBuilder("");
		boolean isWord = false;
		int left = -1;
		int right = -1;
		for(int i = 0; i < text.length(); i++) {
			char tempChar = text.charAt(i);
			//System.out.println(i + " " + tempChar);
			if(tempChar == ' ') {		//tempChar is a blank char
				if(isWord) {				//last char is a letter
					if(left != -1 && right != -1) 
						appendToStringBuilder(text, width, left, right, sBuilder);
					
					isWord = false;		//set isWord
					left = i;
					right = i;
				}
				else {					//last char is blank char
					right++;
				}
			}
			else if((tempChar >= 'a' && tempChar <= 'z') || (tempChar >= 'A' && tempChar <= 'Z')) {	//tempChar is a letter
				if(isWord) {				//last char is a letter
					right++;
				}
				else {					//last char may be null(tempChar is the first chat) or blank char
					if(left != -1 && right != -1) 
						appendToStringBuilder(text, width, left, right, sBuilder);
					
					isWord = true;		//set isWord
					left = i;
					right = i;
				}
			}
			else {
				return "ERROR: Invalid character detected!";		//illegal input
			}
		}
		appendToStringBuilder(text, width, left, right, sBuilder);
		return sBuilder.toString();
	}
	
	/*
	 * append continuous blank char or a word to the stringbuilder
	 */
	public void appendToStringBuilder(String text, int width,int left, int right, StringBuilder sBuilder) {
		sBuilder.append(text.substring(left, right + 1) + '(');
		int beginLine = (left) / width + 1;
		int endLine = (right) / width + 1;
		for(int k = beginLine; k < endLine; k++)
			sBuilder.append(k + ",");
		sBuilder.append(endLine + ");");
	}
	
	public static void main(String[] args) {
		String text = args[0];//"The main theme of education in engineering school is learning to teach yourself";
		int width = Integer.parseInt(args[1]);
		TextProcessor textProcessor = new TextProcessor();
		System.out.println(textProcessor.process(text, width));
	}
}
