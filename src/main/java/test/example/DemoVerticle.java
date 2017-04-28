package test.example;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

@ProxyGen
@VertxGen
public interface DemoVerticle {
    void check(Request request, Handler<AsyncResult<Response>> handler);
}
