package ro.tuc.dsrl.calculator;

import ro.tuc.dsrl.calculator.gui.View;

import javax.swing.*;

public class App 
{
    public static void main( String[] args )
    {

        JFrame frame = new View("Simple calculator using MVC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.pack();
        frame.setVisible(true);
    }
}
