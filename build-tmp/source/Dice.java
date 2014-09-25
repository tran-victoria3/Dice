import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

//Victoria Tran AP Computer Science Dice Program Block 4

public void setup()
{
	size(500,500);
	noLoop();
}
public void draw()
{
	int sum = 0;
	for(int x =0; x <501; x+=8){
		for(int y = 0; y < 501; y +=8){
			Die bob = new Die(x,y);
			bob.roll();
			bob.show();
			sum = sum + bob.number;
		}

	}	
	textSize(50);
	textAlign(CENTER,CENTER);
	stroke(255);
	text("Sum = " + sum, 250,250);
	stroke(0);
}

public void mousePressed()
{
	
	redraw();
}
class Die //models one single dice cube
{
	//variable declarations here
	int xPosition;  //3 member variables
	int yPosition;
	int number;

	Die(int x, int y) //constructor  initializing 3 local variables!
	{
		xPosition = x;
		yPosition = y;


	}
	public void roll()
	{
		number = (int)(Math.random()*6 +1);
	}

	public void show()
	{
		
		rect(xPosition,yPosition,10,10);

		if(number ==1){
			point(xPosition+5,yPosition+5);
		}

		else if(number ==2){

			point(xPosition+4,yPosition+4);
			point(xPosition+8,yPosition+4);
		}

		else if(number ==3){
			point(xPosition+3,yPosition+4);
			point(xPosition+5,yPosition+6);
			point(xPosition+7,yPosition+4);

		}
		else if(number ==  4){
			point(xPosition+3,yPosition+4);
			point(xPosition+5,yPosition+4);
			point(xPosition+3,yPosition+6);
			point(xPosition+5,yPosition+6);
		}
		else if(number == 5){
			point(xPosition+3,yPosition+4);
			point(xPosition+5,yPosition+4);
			point(xPosition+3,yPosition+6);
			point(xPosition+5,yPosition+6);
			point(xPosition+5,yPosition+5);
			
		}
		else if(number ==6){
			point(xPosition+3,yPosition+4);
			point(xPosition+5,yPosition+4);
			point(xPosition+3,yPosition+6);
			point(xPosition+5,yPosition+6);
			point(xPosition+3,yPosition+8);
			point(xPosition+5,yPosition+8);
		}
		

	}



}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
