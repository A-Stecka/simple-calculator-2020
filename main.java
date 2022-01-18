public class main {

    public static void main(String[] args){
        Model CalcLayer = new Model();
        GUI GUILayer = new GUI(CalcLayer);
        Controller Calculator = new Controller(GUILayer, CalcLayer);
    }
}
