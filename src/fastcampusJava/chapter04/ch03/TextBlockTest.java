package fastcampusJava.chapter04.ch03;

public class TextBlockTest {

	public static void main(String[] args) {
		//java compiler에서 Enable 
		String textBlocks="""
				Hello,
				hi~,
				how r u""";
		System.out.println(textBlocks);
		
		String htmlTextBlocks="""
				<html>
					<body>
						<h3>HTML TEXT BLOCKS!</h3>
						<span>example text</span>
					</body>
				</html>""";
		System.out.println(htmlTextBlocks);
	}
	
}
