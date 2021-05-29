package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
    private final List<Vizitka> seznamSVizitkami;

    public VizitkaController() {
        seznamSVizitkami = Arrays.asList(
                new Vizitka("", "Čokoládovna Minach", "Poštovská 450/6E", "Brno 602 00", " minach@cokoladovna.com", "123 456 789", " minachshop.cokoladovna.com"),
                new Vizitka("Pavlína Korcová", "Swing Wings", "Koliště 43", "Brno 602 00", " pilot@swingwings.com", "", " www.swingwings.cz"),
                new Vizitka("Lenka Barvínková", "Stolní tenis & Hravý bar", "Václavská 6", "Brno 603 00", "", "345 678 912", " www.stolnitenisbrno.cz"),
                new Vizitka("", "Zenová škola Kwan Um", "Vrážné 3", "Jevíčko 569 43", " vrazne@vraznezen.org", "", " www.kwanumzen.cz/vrazne")
        );
    }

    @GetMapping("/")
    public ModelAndView zobrazVizitky() {
        ModelAndView myModelView = new ModelAndView("seznam");
        myModelView.addObject("vizitky", seznamSVizitkami);
        return myModelView;
    }

    @GetMapping("/detail")
    public ModelAndView zobrazDetail(int id) {
        ModelAndView myModelView = new ModelAndView("detail");
        myModelView.addObject("vizitka", seznamSVizitkami.get(id));
        return myModelView;
    }
}
