package com.skd.cottagecraft.book.pages;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import com.skd.cottagecraft.Cottagecraft;
import com.skd.cottagecraft.book.BookEntry;
import com.skd.cottagecraft.book.BookPage;

/**
 * A page of text paragraphs ({@code book.cottagecraft.text.<key>}) with ribbons linking to related entries.
 */
public class TextPage extends BookPage {
	private final List<String> textKeys = new ArrayList<>();
	private final Set<BookEntry> relatedEntries = new LinkedHashSet<>();

	public TextPage(BookEntry entry, String... textKeys) {
		super(entry);
		for (String textKey : textKeys) {
			this.textKeys.add("book." + Cottagecraft.NAMESPACE + ".text." + textKey);
		}
	}

	/** Translation keys of the paragraphs. */
	public List<String> getTextKeys() {
		return textKeys;
	}

	public Set<BookEntry> getRelatedEntries() {
		return relatedEntries;
	}

	/** Adds related entries; null entries (disabled in the config) are skipped. */
	public TextPage related(@Nullable BookEntry... entries) {
		for (BookEntry related : entries) {
			if (related != null) {
				relatedEntries.add(related);
			}
		}
		return this;
	}
}
