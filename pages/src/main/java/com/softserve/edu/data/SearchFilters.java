package com.softserve.edu.data;

public class SearchFilters {

	public static enum Field {
        ALL_COLUMNS {
            public String toString() {
                return "All Columns";
            }
        },

        FIRST_NAME {
            public String toString() {
                return "First Name";
            }
        },

        LAST_NAME {
            public String toString() {
                return "Last Name";
            }

        },

        ROLE {
            public String toString() {
                return "Role";
            }
        },

        LOGIN_NAME {
            public String toString() {
                return "Login Name";
            }
        }
    }

    public static enum Condition {
        EQUALS {
            public String toString() {
                return "equals";
            }
        },

        NOT_EQUALS_TO {
            public String toString() {
                return "not equals to";
            }
        },

        STARTS_WITH {
            public String toString() {
                return "starts with";
            }
        },

        CONTAINS {
            public String toString() {
                return "contains";
            }
        },

        DOES_NOT_CONTAIN {
            public String toString() {
                return "does not contain";
            }
        }
    }
}
