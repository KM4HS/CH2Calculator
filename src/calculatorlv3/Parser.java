package calculatorlv3;

import java.util.regex.Pattern;

enum ParserType{
    // NUMBER_REG("^[0-9]*$"),
    OPERATION_REG("[+\\-*/]");

    final private String reg;

    ParserType(String reg){
        this.reg = reg;
    }

    public String getReg(){
        return this.reg;
    }
}

public class Parser {
    public double parseNumber(String numberInput) throws WrongInputException {
        try{
            return Double.parseDouble(numberInput);
        }catch(Exception e){
            throw new WrongInputException(numberInput);
        }
    }

    public char parseOperator(String operatorInput) throws WrongInputException {
        if(Pattern.matches(ParserType.OPERATION_REG.getReg(), operatorInput)){
            return operatorInput.toCharArray()[0];
        }else throw new WrongInputException(operatorInput);
    }
}
