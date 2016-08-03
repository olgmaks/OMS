package com.softserve.edu.data;

public class AddItemPageFilters {
	public static enum SearchProperty {
		ITEM_NAME {
			public String toString() {
				return "Item Name";
			}
		},

		ITEM_DESCRIPTION {
			public String toString() {
				return "Item Description";
			}
		}
	}

	public static enum Dimension {
		ITEM {
			public String toString() {
				return "Item";
			}
		},

		BOX {
			public String toString() {
				return "Box";
			}
		},
		PACKAGE {
			public String toString() {
				return "Package";
			}
		}
	}
}
