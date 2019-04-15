package com.geekzila.books.model;

public class Books extends BaseEntity {

	private int id;
	private String title;
	private String author;
	private int year;
	private int pages;

	public Books(int id, String Title, String Author, int Year, int Pages) {
		this.id = id;
		this.title = Title;
		this.author = Author;
		this.year = Year;
		this.pages = Pages;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	public int getPages() {
		return pages;
	}
}