/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.enums;

/**
 *
 * @author investigacion
 */
public enum CodPasatiempo {
    MUS("MUSCIA"),
    VID("VIDEO JUEGOS"),
    DEP("DEPORTES"),
    LEC("LECTURA");
    
    String texto;

    private CodPasatiempo(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
    
}
