package com.softserve.edu.data;

public class OrderingPageSearchFilters {

	public static enum FilterBy {
        ORDER_STATUS {
            public String toString() {
                return "Status";
            }
        },

        ROLE {
            public String toString() {
                return "Role";
            }
        }
    }

    public static enum FilterValueByStatus {
        NONE {
            public String toString() {
                return "None";
            }
        },

        CREATED{
            public String toString() {
                return "Created";
            }
        },


        PENDING {
            public String toString() {
                return "Pending";
            }
        },

        ORDERED {
            public String toString() {
                return "Ordered";
            }
        },
        
        DELIVERED {
        	public String toString() {
        		return "Delivered";
        	}
        }
    }
    
    public static enum FilterValueByRole {
    	
    	NONE {
    		public String toString() {
    			return "None";
    		}
    	}, 
    	
    	MERCHANDISER {
    		public String toString() {
    			return "Merchandiser";
    		}
    	},
    	
    	ADMINISTRATOR {
    		public String toString() {
    			return "Administrator";
    		}
    	},
    	
    	CUSTOMER {
    		public String toString() {
    			return "Customer";
    		}
    	}
    }
    
    public static enum SearchByValue {
    	
    	ORDER_NAME {
    		public String toString() {
    			return "Order Name";
    		}
    	},
    	
    	ORDER_STATUS {
    		public String toString() {
    			return "Status";
    		}
    	},
    	
    	ASSIGNEE {
    		public String toString() {
    			return "Assignee";
    		}
    	}
    }
    
}
