import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private GUI GUI;
    private Model model;
    public boolean ERASEnotif, MARKERnotif, EQUALnotif, NUMBERnotif, MULTIPLEnotif;
    public static int MARKERcount;

    public Controller(GUI GUI, Model model){
        this.GUI = GUI;
        this.model = model;
        this.GUI.addListener("bERASE", new ERASEListener());
        this.GUI.addListener("bONE", new NUMBERListener("bONE"));
        this.GUI.addListener("bTWO", new NUMBERListener("bTWO"));
        this.GUI.addListener("bTHREE", new NUMBERListener("bTHREE"));
        this.GUI.addListener("bFOUR", new NUMBERListener("bFOUR"));
        this.GUI.addListener("bFIVE", new NUMBERListener("bFIVE"));
        this.GUI.addListener("bSIX", new NUMBERListener("bSIX"));
        this.GUI.addListener("bSEVEN", new NUMBERListener("bSEVEN"));
        this.GUI.addListener("bEIGHT", new NUMBERListener("bEIGHT"));
        this.GUI.addListener("bNINE", new NUMBERListener("bNINE"));
        this.GUI.addListener("bZERO", new NUMBERListener("bZERO"));
        this.GUI.addListener("bDOT", new NUMBERListener("bDOT"));
        this.GUI.addListener("bDIVISION", new MARKERListener("bDIVISION"));
        this.GUI.addListener("bMULTIPLICATION", new MARKERListener("bMULTIPLICATION"));
        this.GUI.addListener("bMINUS", new MARKERListener("bMINUS"));
        this.GUI.addListener("bPLUS", new MARKERListener("bPLUS"));
        this.GUI.addListener("bEQUAL", new EQUALListener());
        this.reset();
    }

    public void reset(){
        ERASEnotif = true;
        MARKERnotif = false;
        EQUALnotif = false;
        MULTIPLEnotif = false;
        NUMBERnotif = false;
        MARKERcount = 0;
    }

    class ERASEListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            model.clearNVALUE();
            GUI.reset();
            reset();
        }
    }

    class NUMBERListener implements ActionListener{
        private String name;

        public NUMBERListener(String name){
            this.name = name;
        }

        public void actionPerformed(ActionEvent e){
            try{
                NUMBERnotif = false;
                String s = "0";
                if(name.equals("bONE")) s = "1";
                if(name.equals("bTWO")) s = "2";
                if(name.equals("bTHREE")) s = "3";
                if(name.equals("bFOUR")) s = "4";
                if(name.equals("bFIVE")) s = "5";
                if(name.equals("bSIX")) s = "6";
                if(name.equals("bSEVEN")) s = "7";
                if(name.equals("bEIGHT")) s = "8";
                if(name.equals("bNINE")) s = "9";
                if(ERASEnotif || MARKERnotif || EQUALnotif){
                    if(name.equals("bDOT")) s = "0.";
                    model.setPVALUE(model.getNVALUE().toString());
                    model.setNVALUE(s);
                    GUI.setTEXT(s);
                    if(EQUALnotif && MARKERcount > 1) model.clearPVALUE();
                }
                else{
                    if(name.equals("bDOT"))
                        s = ".";
                    GUI.addTEXT(s);
                    model.setNVALUE(GUI.getTEXT());
                }
                ERASEnotif = false;
                MARKERnotif = false;
                EQUALnotif = false;
            }catch(NumberFormatException nfex){
                GUI.showError("Podano nieprawidlową liczbę. Dane zostały wyczyszczone.");
                model.clearNVALUE();
                GUI.reset();
                reset();
            }
        }
    }

    class MARKERListener implements ActionListener{
        private String name;

        public MARKERListener(String name){
            this.name = name;
        }

        public void actionPerformed(ActionEvent e){
            if(NUMBERnotif) MULTIPLEnotif = true;
            NUMBERnotif = true;
            MARKERnotif = true;
            MARKERcount++;
            model.setPMARKER(model.getCMARKER());
            if(name.equals("bDIVISION")) model.setCMARKER("bDIVISION");
            if(name.equals("bMULTIPLICATION")) model.setCMARKER("bMULTIPLICATION");
            if(name.equals("bMINUS")) model.setCMARKER("bMINUS");
            if(name.equals("bPLUS")) model.setCMARKER("bPLUS");
            if(MARKERcount > 1)
                try{
                    if(MULTIPLEnotif)
                        throw new MultipleMarkerException("Wciśnięto dwa znaki działania z rzędu. ");
                    else{
                        model.calculate(false);
                        GUI.setTEXT(model.getNVALUE().toString());
                    }
                }catch(ZeroException zex){
                    GUI.showError(zex.getMessage() + "Dane zostały wyczyszczone");
                    model.clearNVALUE();
                    GUI.reset();
                    reset();
                }catch(MultipleMarkerException mmex){
                    GUI.showError(mmex.getMessage() + "Dane zostały wyczyszczone");
                    model.clearNVALUE();
                    GUI.reset();
                    reset();
                }
        }
    }

    class EQUALListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                EQUALnotif = true;
                model.calculate(true);
                GUI.setTEXT(model.getNVALUE().toString());
                MARKERnotif = false;
                MULTIPLEnotif = false;
                NUMBERnotif = false;
                MARKERcount = 0;
            }catch(ZeroException zex){
                GUI.showError(zex.getMessage() + "Dane zostały wyczyszczone.");
                model.clearNVALUE();
                GUI.reset();
                reset();
            }
        }
    }
}
