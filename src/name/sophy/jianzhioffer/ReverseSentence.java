package name.sophy.jianzhioffer;
/*
 * 20180916:翻转英文单词 i am a student. -> student. a am i，不能使用额外空间
 * ab cd -> ba dc->cd ab，先翻转每个单词，再翻转整个字符串
 */
public class ReverseSentence {
	public String ReverseSentence(String str) {
		char [] temp = str.toCharArray();
		int i = 0;
		int j = 0;
		while(j <= str.length()) {
			if(j == str.length() || temp[j] == ' ') {
				reverse(temp, i, j - 1);//将单词进行翻转
				i = j + 1;
			}
			j++;
		}
		reverse(temp, 0, temp.length - 1);
		return new String(temp);
	}
	
	public void reverse(char[] a, int i, int j) {
		while(i < j) {
			char temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		ReverseSentence reverseSentence = new ReverseSentence();
		System.out.println(reverseSentence.ReverseSentence("I am a student."));
	}
}
