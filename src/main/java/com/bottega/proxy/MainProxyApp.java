package com.bottega.proxy;

public class MainProxyApp {

    public static void main(String[] args) {

        TrainAppContext context = new TrainAppContext();

        System.out.println("creating engine");
        Train train = context.getTrain(false);
        System.out.println("run engine");
        train.run("A,B,C");
        System.out.println("stop engine");
        train.stop();

        System.out.println("\n\n\n");

        System.out.println("creating proxy engine");
        Train train2 = context.getTrain(true);
        System.out.println("run engine");
        train2.run("A,C,X");
        System.out.println("stop engine");
        train2.stop();

    }



    static class Train {

        private final Engine engine;
        //...

        Train(Engine engine) {
            this.engine = engine;
        }


        void run(String options){
            engine.run(options);
            //...
        }

        void  stop() {
            engine.stop();
        }
    }


}
