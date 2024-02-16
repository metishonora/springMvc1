package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

public class ModelView {

    @Getter @Setter
    private String viewName;

    @Getter @Setter
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String viewName) {
        this.viewName = viewName;
    }
}
