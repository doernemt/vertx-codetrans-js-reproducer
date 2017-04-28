package test.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.serviceproxy.ProxyHelper;

public class DemoVerticleImpl extends AbstractVerticle implements DemoVerticle {
    @Override
    public void check(Request request, Handler<AsyncResult<Response>> handler) {
        handler.handle(Future.succeededFuture(new Response().setSuccessful(true)));
    }

    @Override
    public void start() throws Exception {
        super.start();
        ProxyHelper.registerService(DemoVerticle.class, vertx, this, "myAddress");
    }
}
