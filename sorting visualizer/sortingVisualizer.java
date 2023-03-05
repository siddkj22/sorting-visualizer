package searchsort;
import processing.core.* ;

public class searc extends PApplet {
	int width = 1100;
	int heigth = 600;
	int rectW = width /2 ;
	
	int i = 0;
	int j = 0;
	int index = 0;
	
	float[] lines = new float[width];
	
	public void setup(){
	   size (width,heigth);
	   for(int i = 0 ; i < lines.length ; i++) {
		   lines[i] = random(heigth);
	   }	   
	}
	public void draw() {		
		stroke(100);		
		for(int i = 0 ; i < lines.length ; i++) {
			line (i , height , i , height - lines[i]);
		}		
		background(255);
		
		 stroke(100);
		 rect(60,40,90,30);
		 fill(0,0,0);
		 text("selection sort" , 70 , 60);
		 fill(255,0,0);
		 
		 rect(60,70,90,30);
		 fill(0,0,0);
		 text("insertion sort" , 70 , 90);
		 fill(255,0,0);
		 
		 rect(60,100,90,30);
		 fill(0,0,0);
		 text("bubble sort" , 70 , 120);
		 fill(255,0,0);
		 
		 rect(60,130,90,30);
		 fill(0,0,0);
		 text("merge sort" , 70 , 150);
		 fill(255,0,0);
	 
		 rect(60,160,90,30);
		 fill(0,0,0);
		 text("shuffle sort" , 70 , 180);
		 fill(255,0,0);
		 
		 rect(60,190,90,30);
		 fill(0,0,0);
		 text("shuffle",70,210);
		 fill(255,0,0);
		 
	
		for(int i = 0 ; i < lines.length ; i++) {
			line (i , height , i , height - lines[i]);
		}
	
		mouseReleased();
	}
	
	@Override
	public void mouseReleased() {
		if(mouseX > 60 && mouseX < 150 && mouseY > 40 && mouseY < 70) {
			if(i < lines.length) {
				int indexMin = i;
				for(int j = i + 1 ; j < lines.length ; j++) {
					if(lines[j] < lines[indexMin]) {
						indexMin = j ;					
					}
					swap(lines , indexMin , i);
				}
				i++;
			}
				
		}else if(mouseX > 60 && mouseY < 150 && mouseY > 70 && mouseY < 100) {
			if(i < lines.length) {
				for(int j = 0 ; j < lines.length ; j++) {
					if( lines[i] < lines[j]) {
						swap(lines, i , j);
					}
				}
				i++;
			}
		}else if(mouseX > 60 && mouseX < 150 && mouseY > 90 && mouseY < 130) {
			int N = lines.length;
			int h = 1;
			 while (h < N/3) h = 3*h + 1;                
			 
			if(lines.length > 0) { 
			 while(h >= 1) {   
			         for (int i = h; i < N; i++) {		        	 	        	 
			           for (int j = i; j >= h && lines[j] < lines[j-h]; j -= h)
			                swap(lines, j, j-h);
			           }
		
			 h = h/3;
			 
			 }
			
			}
			
		}else if(mouseX > 60 && mouseX < 150 && mouseY > 110 && mouseY < 160) {
			int N = lines.length;
			for(int i = 0 ; i < N ; i++) {
				int r = (int ) (Math.random() * N);   //random(i + 1));    //Random.uniform(i + 1);
				swap (lines , i , r);
			}
		}else if(mouseX > 60 && mouseX < 150 && mouseY > 140 && mouseY < 190) {
			System.out.print("akjdn");
			int N = lines.length;
			int lo = 0;
			int mid = N/2;
			int hi = N;
			float[]  aux = new float[lines.length];
			for(int k = 0 ; k < N; k++) {
				aux[k] = lines[k];
			}
			int i = lo; 
			int j = mid + 1;
			for(int k = lo ; k <= hi ; k++) {
				if(i > mid)     lines[k] = aux[j++];
				else if (j > hi)    lines[k] = aux[i++];
				else if (aux[j] < aux[i])          lines[k] = aux[j++];
				else            lines[k] = aux[i++];
				
			}
		}
	}
	
	
	
	public void swap (float[] arr , int i , int j ) {
		float temp = arr[i];
		arr[i]  = arr[j] ;
		arr[j] = temp;
	}

}
