package test.example;

import io.vertx.core.Vertx;
import io.vertx.serviceproxy.ProxyHelper;

public class ExampleSourceForDocumentation {
    private static Vertx vertx;

    private static DemoVerticle ex;

    public void demo(String sampleInput) {
        Request data = new Request().setInput(sampleInput);
        ex.check(data, checkResult -> {
            if(checkResult.succeeded()) {
                if (checkResult.result().isSuccessful()) {
                    System.out.println("Yeah! ");
                } else {
                    System.out.println("Nah!");
                }
            } else {
                System.out.println("ERROR: "+checkResult.cause().getLocalizedMessage());
            }
        });
    }

    public static void main(String[] args) {
        vertx = Vertx.vertx();
        vertx.deployVerticle("test.example.ExampleImpl", res -> {
            ExampleSourceForDocumentation realExample = new ExampleSourceForDocumentation();
            ex = ProxyHelper.createProxy(DemoVerticle.class, vertx, "myAddress");
            realExample.demo("bla");
        });

    }
}
