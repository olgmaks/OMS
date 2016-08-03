package com.softserve.edu.data;

/**
 * Created by istebktc
 */

/**
 * Contains values of dropdown filter of ItemManagement page of Supervisor role
 */

public class SupervisorItemManagementPageFilters {
    public static enum SupervisorField {
        PRODUCT_NAME {
            public String toString() {
                return "Product Name";
            }
        },

        DESCRIPTION {
            public String toString() {
                return "Description";
            }
        }
    }
}
