package controllers;
import com.google.inject.Inject;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import java.util.Optional;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private final FormFactory formFactory;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    @Inject
    public HomeController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result index() {
        return ok(views.html.index.render());
    }




    public Result about(Http.Request request) {
        Form<User> userForm = formFactory.form(User.class).bindFromRequest(request);
        if (userForm.hasErrors()) {
            // Renderiza la página principal con un mensaje de error
            return badRequest(views.html.index.render());
        }
        // Obtiene los datos del formulario
        User user = userForm.get();
        String message = "Hello " + user.getName() + "!";

        // Renderiza la página `about` con el mensaje
        return ok(views.html.about.render(message));
    }



    public Result operaciones() {
        return ok(views.html.suport.render());
    }

}
