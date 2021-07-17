package view;

public class Animation extends Thread{
    boolean flag = false;
    Animatable target ;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Animation(Animatable target) {
        this.target = target;
    }

    @Override
    public void run() {
        while (true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (flag){
                target.nextFrame();

            }
        }
    }
}
