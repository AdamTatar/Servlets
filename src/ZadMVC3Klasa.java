
public class ZadMVC3Klasa {
	
	private String title;
	public ZadMVC3Klasa(String title, String author, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "ZadMVC3Klasa [title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	private String author;
	private String isbn;
	
	
	

}
