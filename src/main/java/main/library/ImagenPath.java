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
}
