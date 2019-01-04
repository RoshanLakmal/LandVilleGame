import java.util.Arrays;

public class LandVille {
	
	private int[][] land;
	private boolean hasHouse;
	private int landRow;
	private int landCol;
    
	//LandVille Constructor.
    public LandVille(int row, int col) {
    	
    	//Initialises landRow and landCol.
    	this.landRow = row;
    	this.landCol = col;
    	
    	//Initialises land with size of row and column.
    	land = new int [row][col];
    	
    	//Initialise plot to '0'. 
    	clearLand();
    	
    	//Initialise hasHouse to false.
    	hasHouse = false;
    }
    
    
    //displayLand method.
    public void displayLand() {
    	
    	//Looping the 2D array and displaying the results.
    	for ( int i = 0; i < land.length; i++ ) {
    		for ( int j = 0; j < land[i].length; j++ ) {
    			System.out.print(land[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    
    
    //clearLand method. 
    public void clearLand() {
    	
    	// Looping the 2D array and initialises land with size of row and column to plot '0'. 
    	for ( int i = 0; i < land.length; i++ ) {
    		for ( int j = 0; j < land[i].length; j++ ) {
    			land[i][j] = 0;
    		}
    	}
    	
    	// Sets hasHouse to false
    	hasHouse = false;
   
    }
    
    
    //buildHouse method.
    public void buildHouse(int hrow, int hcol) {
    	
    	//Checking the condition on input. 
    	if (hrow < 1 && hcol < 1){
    		System.out.println("Invalid input. Row and Column number need to be greater than 0");
    		return;
    	}else if ( landRow - hrow < 2){
    		System.out.println("Invalid input. Row of house needs to less than or equal to " + (landRow - 2) + ". No house is built.");
    		return;
    	}else if (landCol - hcol < 2){
    		System.out.println("Invalid input. Column of house needs to less than or equal to " + (landCol - 2) + ". No house is built.");
    		return;
    	}else{
    		
    		//Building the house by looping the 2D array and initialises land with size of row and column to plot '8'. 
        	for ( int i = 1; i < hrow+1; i++ ) {
        		for (int j = 1; j < hcol+1; j++ ) {
        			land[i][j] = 8;
        		}
        	}
        	
        	//Building the fence by looping the 2D array and initialises land with size of row and column to plot '1'.
        	for (int i = 0; i < hrow+2; i++) {
    			for (int j = 0; j < hcol+2; j++) {
    				if (land[i][j] == 0) {
    					land[i][j] = 1;
    				}
    			}
    		}
        	
        	//Updating the hasHouse to true.
        	hasHouse = true;
        	
        	//Calling displayLand method.
        	displayLand();
    	}	
    }
    
    
    //Get method for hasHouse
    public boolean isHasHouse() {
		return hasHouse;
	}

}
