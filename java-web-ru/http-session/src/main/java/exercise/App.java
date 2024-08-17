package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            String pageParam = ctx.queryParam("page");
            String perParam = ctx.queryParam("per");

            int page = (pageParam != null) ? Integer.parseInt(pageParam) : 1;
            int per = (perParam != null) ? Integer.parseInt(perParam) : 5;

            int start = (page - 1) * per;
            int end = Math.min(start + per, USERS.size());

            ctx.json(USERS.subList(start, end));
        });

        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
