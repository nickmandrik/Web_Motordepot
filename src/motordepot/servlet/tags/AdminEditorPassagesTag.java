package motordepot.servlet.tags;

import motordepot.entities.User;
import motordepot.servlet.MotorDepotServlet;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Tag used only by users with admin relate
 * Created by Nick Mandrik on 15.05.2017.
 */
public class AdminEditorPassagesTag extends SimpleTagSupport {

    private StringWriter sw = new StringWriter();

    @Override
    public void doTag() throws JspException, IOException {
        HttpSession session = ((PageContext)getJspContext()).getSession();
        Object o = session.getAttribute("user");
        if (o != null) {
            User user = (User) o;
            if (user.getRole().equals("admin")) {
                getJspBody().invoke(sw);
                getJspContext().getOut().println(sw.toString());
            }
        }
    }
}