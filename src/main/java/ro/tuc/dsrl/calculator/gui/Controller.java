package ro.tuc.dsrl.calculator.gui;

import ro.tuc.dsrl.calculator.logic.Operations;
//import ro.tuc.dsrl.calculator.models.Number;
import ro.tuc.dsrl.calculator.models.Polynomial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements ActionListener {

    private View view;
    private Operations operations = new Operations();
    public Controller(View v){
        this.view = v;
    }

    public void assign(Map<Integer, Number> monomial, Integer degree, Integer coeff){
        Number c;
        c = coeff;

        if (monomial.containsKey(degree)){
            monomial.put(degree,c.intValue() + monomial.get(degree).intValue());
            System.out.println("degree " + degree + " coef " + c.intValue());
        }else{
            monomial.put(degree,c);
            System.out.println("degree " + degree + " coef " + c.intValue());
        }
    }

    public void polyParse(String number, Polynomial pol){
        Map<Integer, Number> monomial = new HashMap<Integer,Number>();

        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");

        Pattern patternin = Pattern.compile("([-+]?\\b\\d+)x\\^(\\d+\\b)");
        Pattern patternValue = Pattern.compile("[-+]?\\b\\d+");
        Pattern patternCoeff = Pattern.compile("([-+]?\\b\\d+)x");
        Pattern patternDegree = Pattern.compile("([-+])(\\d+\\b)?x\\^(\\d+\\b)");

        Matcher matcher = pattern.matcher(number);

        int x=0;
        while (matcher.find()) {
            x=x+1;
            System.out.println(" "+x+": " + matcher.group(1));

            Matcher matcherin = patternin.matcher(matcher.group(1));
            Matcher matcherCoeff = patternCoeff.matcher(matcher.group(1));
            Matcher matcherDeg = patternDegree.matcher(matcher.group(1));
            Matcher matcherVal = patternValue.matcher(matcher.group(1));

            if(matcherin.matches()){
                //System.out.println(" "+x+": " + matcherin.group(1) + " " + matcherin.group(2));
                assign(monomial,Integer.parseInt(matcherin.group(2)),Integer.parseInt(matcherin.group(1)));
            } else if(matcherCoeff.matches()){
                //System.out.println(" "+x+": " + matcherCoeff.group(1) + " 1");
                assign(monomial,1,Integer.parseInt(matcherCoeff.group(1)));
            } else if (matcherDeg.matches()){
                //System.out.println(" "+x+": "+ matcherDeg.group(1) +"1 " + matcherDeg.group(3));
                String c=matcherDeg.group(1) +"1";
                assign(monomial,Integer.parseInt(matcherDeg.group(3)),Integer.parseInt(c));
            } else if (matcherVal.matches()){
                //System.out.println(" "+x+": " + matcherVal.group(0) + " 0");
                assign(monomial,0,Integer.parseInt(matcherVal.group(0)));
            } else{
                System.out.println("Input Error, please rewrite the polynoms!");
            }
        }
        //System.out.println("HERE IT GOES");//For verification
        pol.setMonomials(monomial);
        pol.ppPrint();
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command == "COMPUTE"){
            Polynomial firstPolynomial = new Polynomial();
            Polynomial secondPolynomial = new Polynomial();

            polyParse(String.valueOf(view.getFirstNumberTextField().getText()), firstPolynomial);
            //System.out.println("The second one");//For marking the start of the second polynomial
            polyParse(String.valueOf(view.getSecondNumberTextField().getText()), secondPolynomial);

            firstPolynomial.complete();
            secondPolynomial.complete();

            String operation = String.valueOf(view.getOperationsComboBox().getSelectedItem());
            Polynomial result = null;

            switch(operation){
                case "Add": result = operations.add(firstPolynomial, secondPolynomial);
                            break;
                case "Subtract": result = operations.subtract(firstPolynomial, secondPolynomial);
                                break;
                case "Multiply": result = operations.multiply(firstPolynomial, secondPolynomial);
                                break;
            }
            view.getResultValueLabel().setText(result.preetyPrint());
        }
    }
}
