/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.web;

import ec.edu.espe.distribuidas.agilizate.model.Categoria;
import ec.edu.espe.distribuidas.agilizate.model.Genero;
import ec.edu.espe.distribuidas.agilizate.service.CategoriaService;
import ec.edu.espe.distribuidas.agilizate.service.GeneroService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author DanielCasa
 */
@Named
@ViewScoped
public class CategoriaBean extends BaseBean implements Serializable{
    
    private List<Categoria> categorias;

    @Inject
    private CategoriaService generoService;
    
    @PostConstruct
    public void init() {
        this.categorias = this.generoService.obtenerTodos();
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
    
}
