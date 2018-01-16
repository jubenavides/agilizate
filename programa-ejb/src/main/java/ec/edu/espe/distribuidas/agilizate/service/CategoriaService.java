/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.service;

import ec.edu.espe.distribuidas.agilizate.dao.CategoriaFacade;
import ec.edu.espe.distribuidas.agilizate.enums.CodCategoriaEnum;
import ec.edu.espe.distribuidas.agilizate.model.Categoria;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author DanielCasa
 */
@Stateless
@LocalBean
public class CategoriaService{

    @EJB    
    private CategoriaFacade categoriaFacade;
   
    public List<Categoria> obtenerTodos() {
        return this.categoriaFacade.findAll();
    }
    
    public Categoria obtenerPorCodigo(CodCategoriaEnum codigo) {
        return this.categoriaFacade.find(codigo);
    }
    
    public void crear(Categoria categoria) {
        this.categoriaFacade.create(categoria);
    }
}
