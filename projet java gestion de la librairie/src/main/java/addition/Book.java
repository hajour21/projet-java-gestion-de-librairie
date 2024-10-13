package addition;

public class Book {
 private String Title;
private String ISBN; 
private String Author ;
private String Language ;
private int Year ;
private String Abstract; 


public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}
public String getISBN() {
	return ISBN;
}
public void setISBN(String iSBN) {
	ISBN = iSBN;
}
public String getAuthor() {
	return Author;
}
public void setAuthor(String author) {
	Author = author;
}
public String getLanguage() {
	return Language;
}
public void setLanguage(String language) {
	Language = language;
}
public int getYear() {
	return Year;
}
public void setYear(int year) {
	Year = year;
}
public String getAbstract() {
	return Abstract;
}
public void setAbstract(String abstract1) {
	Abstract = abstract1;
}
public Book(String Title, String ISBN , String Author , String Language , int Year , String Abstract ) {
this.setTitle(Title); 
this.setISBN(ISBN) ;
this.setAuthor(Author) ; 
this.setLanguage(Language);
this.setYear(Year); 
this.setAbstract(Abstract);
	}
Book() {}
}
