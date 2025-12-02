// Alex Krouse
// 12/1/25
// Determines if water can flow off a map from a point chosen

package water;

public class FLOW {

	public static void main(String[] args){
		int[][] FirstMap = {
			{100, 99, 200, 200, 200, 200, 200, 200, 200, 200}, 
			{200, 98, 200, 200, 200, 200, 200, 200, 200, 200},
			{200, 97, 96, 200, 200, 200, 200, 200, 200, 200},
			{200, 200, 95, 200, 200, 200, 85, 84, 83, 200},
			{200, 200, 94, 93, 92, 200, 86, 200, 82, 200},
			{200, 150, 200, 200, 91, 200, 87, 200, 81, 200},
			{200, 200, 200, 200, 90, 89, 88, 200, 80, 200},
			{200, 150, 100, 200, 200, 200, 200, 200, 79, 200},
			{200, 200, 200, 200, 200, 200, 200, 200, 78, 77},
			{200, 98, 200, 200, 200, 200, 200, 200, 200, 76}		
		};
		canFlowOff(FirstMap, 1, 1);
			
	 	int[][] TestMap = {
			{100, 200, 200, 200, 200, 200, 200, 200, 200, 200}, 
			{200, 200, 200, 200, 200, 200, 200, 200, 200, 200},
			{200, 10, 200, 200, 200, 200, 200, 200, 200, 200},
			{200, 11, 10, 200, 200, 6, 85, 84, 83, 200},
			{200, 200, 14, 15, 59, 200, 86, 200, 82, 200},
			{200, 11, 12, 200, 200, 200, 87, 200, 81, 200},
			{200, 10, 200, 200, 90, 89, 88, 200, 200, 200},		
			{200, 9, 8, 200, 200, 200, 200, 200, 200, 200},
			{200, 200, 7, 200, 200, 200, 200, 200, 200, 200},
			{200, 98, 6, 200, 200, 200, 200, 200, 200, 200}
		};
		canFlowOff(TestMap, 4, 5);
		

		int[][] smallMap = {
			{100, 100, 100}, 
			{100, 200, 200},
			{100, 100, 300}
		};
		canFlowOff(smallMap, 1, 1);
}

 // Recursive method to determine if water can flow off the map
 // pre: map is a defined array of numbers 
 // post: returns true if water can flow off the map from (row, col), false otherwise]
	static boolean canFlowOff(int[][] map, int row, int col){
		

		if (row < 0 || row >= map.length || col < 0 || col >= map[0].length){
			System.out.println("false");
			return false;
		}
		
	 	if(row == 0 || row == map.length-1 || col == 0 || col == map[0].length-1){
			System.out.println("true");
			return true;
		} else {
		   if (map[row][col] > map[row][col-1]){
				return canFlowOff (map, row, col-1);
		   } else if(map[row][col] > map[row+1][col]){
			   return canFlowOff (map, row+1, col);
		   } else if(map[row][col] > map[row-1][col]){
			   return canFlowOff (map, row-1, col); 
		   } else if(map[row][col] > map[row][col+1]){
			   return canFlowOff (map, row, col+1);
		   }
		}
		System.out.println("false");
		return false;
	}
}