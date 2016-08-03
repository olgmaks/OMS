package com.softserve.edu.data;

public class AddItemPageDimensionFilters {
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
