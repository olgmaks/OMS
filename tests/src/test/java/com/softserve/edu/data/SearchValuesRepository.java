package com.softserve.edu.data;

public class SearchValuesRepository {

	public static enum ValidSearchByStatus {
        CREATED {
            public String toString() {
                return "created";
            }
        },

        PENDING {
            public String toString() {
                return "pending";
            }
        },
        
        PEN {
            public String toString() {
                return "pen";
            }
        }
    }
	
	public static enum InvalidSearchByStatus {
        REATED {
            public String toString() {
                return "reated";
            }
        },

        ENDING {
            public String toString() {
                return "ending";
            }
        }
    }
	
	public static enum ValidSearchByOrderName {
        CREATED {
            public String toString() {
                return "OrderName5";
            }
        },

        PENDING {
            public String toString() {
                return "oRDE";
            }
        }
    }

	public static enum InvalidSearchByOrderName {
        CREATED {
            public String toString() {
                return "rName5";
            }
        },

        PENDING {
            public String toString() {
                return "owRDE";
            }
        }
    }
	
	public static enum ValidSearchByAssignee {
        VITALIK {
            public String toString() {
                return "Vitalik";
            }
        },

        MYROSLAV {
            public String toString() {
                return "myroslav";
            }
        }
    }
	
	public static enum InvalidSearchByAssignee {
        ALIK {
            public String toString() {
                return "alik";
            }
        },

        AAAAA {
            public String toString() {
                return "aaaaa";
            }
        }
    }
	
}	