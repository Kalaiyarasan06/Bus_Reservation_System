package BusResrv;
public class Bus {
    private int Busno;
    private boolean  Ac;
    private int capacity;
    Bus(int no,boolean ac,int cap){
        this.Busno=no;
        this.Ac=ac;
        this.capacity=cap;
    }
    public int getBusno(){
        return Busno;
    }
    public void setBusno(int no){
        Busno=no;
    }
    public boolean getAc(){
        return Ac;
    }
    public void setAc(boolean ac){
        Ac=ac;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void Displaybusinfo(){
        System.out.println("Bus No:"+Busno+" AC:"+Ac+" Total Capacity :"+capacity);
    }
}
