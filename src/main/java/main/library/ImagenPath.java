package main.library;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ImagenPath {

    private final String ROUTE_RELATIVE = "src/main/java/resources/";
    private Path routeRelative;
    private Path routeAbsolute;

    /**
     * Metodo que regresa un {@code String} con la ruta completa del elemento.
     *
     * @param nombre nombre del elemento.
     * <ul>
     * <li>El nombre debe incluir la extensión del elemento</li>
     * <li>Ejemplo:
     * <p>
     * ejemplo.png</p>
     * </li>
     * </ul>
     * @return retorna la ruta completa.
     */
    public String ruta(String nombre) {
        routeRelative = Paths.get(ROUTE_RELATIVE + nombre);
        routeAbsolute = routeRelative.toAbsolutePath();
        return String.valueOf(routeAbsolute);
    }

    public enum Imagenes {
        ACCEPT("accept.png"),
        ADD("add.png"),
        CANCEL("cancel.png"),
        CLEAN("clean.png"),
        CLOSE("close.png"),
        ICON("icon.png"),
        PRIMERO("left_doble.png"),
        ANTERIOR("left_icon.png"),
        MIN("min.png"),
        REMOVE("remove.png"),
        ULTIMO("right_doble.png"),
        SIGUIENTE("right_icon.png"),
        SEARCH("search.png");
        private final String value;

        Imagenes(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
