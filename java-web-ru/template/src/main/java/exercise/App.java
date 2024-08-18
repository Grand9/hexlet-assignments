package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Optional;

import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            UsersPage usersPage = new UsersPage(USERS, "Список пользователей");
            ctx.render("users/index.jte", usersPage);
        });

        app.get("/users/:id", ctx -> {
            long id = Long.parseLong(ctx.pathParam("id"));
            Optional<User> userOpt = USERS.stream().filter(user -> user.getId() == id).findFirst();

            if (userOpt.isPresent()) {
                UserPage userPage = new UserPage(userOpt.get());
                ctx.render("users/show.jte", userPage);
            } else {
                ctx.status(404).result("User not found");
            }
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
