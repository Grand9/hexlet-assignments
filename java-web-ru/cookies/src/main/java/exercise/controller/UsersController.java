package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;

import java.util.Collections;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void register(Context ctx) throws Exception {
        var firstName = ctx.formParamAsClass("firstName", String.class).get();
        var lastName = ctx.formParamAsClass("lastName", String.class).get();
        var email = ctx.formParamAsClass("email", String.class).get();
        var password = ctx.formParamAsClass("password", String.class).get();
        var token = Security.generateToken();

        ctx.cookie("userToken", token);
        var user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);

        var id = UserRepository.search(firstName).get(0).getId();
        ctx.redirect(NamedRoutes.userPath(id));
    }
    public static void show(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));
        var token = ctx.cookie("userToken");
        if (user.getToken().equals(token)) {
            var userPage = new UserPage(user);
            ctx.render("users/show.jte", Collections.singletonMap("page", userPage));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }
    // END
}
