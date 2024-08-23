package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;

import java.util.HashMap;
import java.util.Optional;

public class SessionsController {

    public static void rootPage(Context ctx) {
        var user = ctx.sessionAttribute("currentUser");
        var page = new MainPage(user);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage("", "");
        var attributes = new HashMap<String, Object>();
        attributes.put("page", page);
        attributes.put("errorMessage", page.getError() != null ? page.getError() : "");
        ctx.render("build.jte", attributes);
    }

    public static void create(Context ctx) {
        var nickname = ctx.formParam("name");
        var password = ctx.formParam("password");
        Optional<exercise.model.User> userOptional = UsersRepository.findByName(nickname);

        if (userOptional.isEmpty() || !userOptional.get().getPassword().equals(encrypt(password))) {
            var page = new LoginPage(nickname, "Wrong username or password");
            ctx.render("build.jte", Collections.singletonMap("page", page));
        } else {
            ctx.sessionAttribute("currentUser", nickname);
            ctx.redirect(NamedRoutes.rootPath());
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
}
