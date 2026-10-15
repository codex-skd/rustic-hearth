package com.skd.cottagecraft.book.pages;

import java.util.List;

import com.skd.cottagecraft.book.BookCategory;
import com.skd.cottagecraft.book.BookEntry;
import com.skd.cottagecraft.book.BookPage;

/**
 * The index page: one animated button per category.
 */
public class CategoriesPage extends BookPage {
	private final List<BookCategory> categories;

	public CategoriesPage(BookEntry entry, List<BookCategory> categories) {
		super(entry);
		this.categories = categories;
	}

	public List<BookCategory> getCategories() {
		return categories;
	}
}
