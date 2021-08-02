package kr.or.ddit.vo;

public class BookAtchVO {

	private int seq;
	private String pictureUrl;
	private int bookId;

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	@Override
	public String toString() {
		return "bookAtch [seq=" + seq + ", pictureUrl=" + pictureUrl + ", bookId=" + bookId + "]";
	}
}
