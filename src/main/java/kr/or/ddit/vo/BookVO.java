package kr.or.ddit.vo;

public class BookVO {

	private int bookId;
	private String title;
	private String category;
	private int price;

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "book [bookId=" + bookId + ", title=" + title + ", category=" + category + ", price=" + price + "]";
	}
}
