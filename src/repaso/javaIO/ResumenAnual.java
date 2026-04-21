package repaso.javaIO;

import java.util.HashMap;
import java.util.Map;

public class ResumenAnual {

    private Map <String, Integer> paginasPorGenero;

    public ResumenAnual(Map<String, Integer> paginasPorGenero) {
        paginasPorGenero.put("Ficcion", 0);
        paginasPorGenero.put("Ensayo", 0);
        paginasPorGenero.put("Historia", 0);
        paginasPorGenero.put("Ciencia", 0);
        paginasPorGenero.put("Poesia", 0);
    }

    public void sumarPaginas (String genero, int paginas){
        if(paginasPorGenero.containsKey(genero)){
            int acumulado = paginasPorGenero.get(genero);
            paginasPorGenero.put(genero, acumulado + paginas);
        }
    }

    public Map<String, Integer> getPaginasPorGenero() {
        return paginasPorGenero;
    }

}
