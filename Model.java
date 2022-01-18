public class Model {
    private static final String initialVALUE = "0";
    private Double previousVALUE, newVALUE;
    private String calcMARKER, previousMARKER;

    public Model(){
        clearNVALUE();
        clearPVALUE();
    }

    public void clearNVALUE(){
        newVALUE = new Double(initialVALUE);
    }

    public void clearPVALUE(){
        previousVALUE = new Double(initialVALUE);
    }

    public void setNVALUE(String text){
        newVALUE = new Double(text);
    }

    public void setPVALUE(String text){
        previousVALUE = new Double(text);
    }

    public void setCMARKER(String text){
        calcMARKER = text;
    }

    public void setPMARKER(String text){
        previousMARKER = text;
    }

    public void calculate(boolean b) throws ZeroException {
        if(newVALUE == 0 && calcMARKER.equals("bDIVISION"))
            throw new ZeroException("Próba dzielenia przez zero. ");
        if(b){
            if(calcMARKER.equals("bDIVISION")) newVALUE = previousVALUE / newVALUE;
            if(calcMARKER.equals("bMULTIPLICATION")) newVALUE = previousVALUE * newVALUE;
            if(calcMARKER.equals("bMINUS")) newVALUE = previousVALUE - newVALUE;
            if(calcMARKER.equals("bPLUS")) newVALUE = previousVALUE + newVALUE;
        }
        else{
            if(previousMARKER.equals("bDIVISION")) newVALUE = previousVALUE / newVALUE;
            if(previousMARKER.equals("bMULTIPLICATION")) newVALUE = previousVALUE * newVALUE;
            if(previousMARKER.equals("bMINUS")) newVALUE = previousVALUE - newVALUE;
            if(previousMARKER.equals("bPLUS")) newVALUE = previousVALUE + newVALUE;
        }
    }

    public String getIVALUE(){
        return initialVALUE;
    }

    public Double getNVALUE(){
        return newVALUE;
    }

    public String getCMARKER(){
        return calcMARKER;
    }
}
