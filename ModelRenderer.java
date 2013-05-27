/* 
 * NAME: Joshua Nason
 * COS 160, Spring 2013, Prof. Welty
 * Program #8
 * File Name: ModelRenderer.java
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import java.io.*;

public class ModelRenderer {
    static Graphics g;   // specified as class variable to avoid passing as argument
    
    // Program to render the objects described in the model file
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(500, 500);
        g = panel.getGraphics();
        Scanner input = null;
        try {
            input = new Scanner(new File("grid.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR - File not found");
            System.exit(1);
        }
        
        while (input.hasNextLine()) {
            String text = input.nextLine();
            renderCommand(text);
        }        
    }

    // takes a String rendering command and renders the specified
    // line, oval, or rectangle to the drawing panel
    public static void renderCommand(String text) {
        Scanner commandLine = new Scanner(text);
        if (!commandLine.hasNext()) { // skip blank lines
            return;
        }
     	
        String command = commandLine.next(); 
        if (command.equals("line")) {
           g.setColor(new Color (commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt()));
           		g.drawLine(commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt());}
        if (command.equals("rect")) {
        	g.setColor(new Color (commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt()));
         		g.drawRect(commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt());
         		}
   		if (command.equals("oval")){
         	g.setColor(new Color (commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt()));
          		g.drawOval(commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt());   
          		}
        if (command.equals("roundrect")) {
          	g.setColor(new Color (commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt()));
          		g.drawRoundRect(commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt());
          		}
        if (command.equals("string")) {
          	g.setColor(new Color (commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt()));
           		g.drawRect(commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt());
           		}
      	if (command.equals("linetween")) {
          	g.setColor(new Color (commandLine.nextInt(),commandLine.nextInt(),commandLine.nextInt()));
        		int x1=commandLine.nextInt(); int y1=commandLine.nextInt(); int x2=commandLine.nextInt(); int y2=commandLine.nextInt(); int sx1=commandLine.nextInt(); int sy1=commandLine.nextInt(); int sx2=commandLine.nextInt(); int sy2=commandLine.nextInt();
        		double tween= commandLine.nextInt()+2.0, x1change=(sx1-x1)/tween, x2change=(sx2-x2)/tween;
        			double y1change=(sy1-y1)/tween, y2change=(sy2-y2)/tween;
        			for(int i=0; i<=tween; i++){
        					g.drawLine((int)(x1+i*x1change), (int)(y1+i*y1change),(int)(x2+i*x2change),(int)(y2+i*y2change));
        			}
        }	

    }


}

