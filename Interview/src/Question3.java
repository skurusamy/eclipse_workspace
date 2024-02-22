

public class Question3 {

	public static void main(String[] args) {
		
		int[][]arr= {{3,5,3,9,5},
				{4,3,2,1,8},{9,4,3,1,9},{8,2,4,6,4},
				{1,2,5,9,1}	};
		int val = 3;
		int i=0,j=0;
		int count =0;
		for(i=0;i<arr.length;i++) {
			for(j =0;j<arr[0].length;j++) {
				if(arr[i][j]== val) {
					//top to bottom
					for(int start = i;start<arr.length;start++) {
						if(arr[start][j]==val)
							count++;
					}
					//bottom to top
					for(int start=i;start>00;i--) {
						if(arr[start][j]==val)
							count++;
					}
					//left to right
					for(int start= j;start<arr.length;start++) {
						if(arr[i][start]==val)
							count++;
					}
				//right to left
					for(int start= j;start>0;start--) {
						if(arr[i][start]==val)
								count++;
					}
					for(int start =i;start<arr.length;start++) {
						for(int end =j;end<arr[0].length; end++) {
							if(arr[start][end]==val)
								count++;
						}
					}
					for(int start =i;start>0;start--) {
						for(int end =j;end>0 ;end--) {
							if(arr[start][end]==val)
								count++;
						}
					}
				}
			}
		}
		//return count;
		System.out.println(count);
		
	}
}
