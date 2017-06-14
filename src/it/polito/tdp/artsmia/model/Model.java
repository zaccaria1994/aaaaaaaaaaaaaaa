package it.polito.tdp.artsmia.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import it.polito.tdp.artsmia.db.ArtsmiaDAO;

public class Model {
	SimpleDirectedGraph<Exhibitions,DefaultEdge>grafo;
	
	ArtsmiaDAO ad=new ArtsmiaDAO();

	public Model() {
		
	}
	public List<Integer>getAnno(){
		return ad.year();
		
	}
	public void creaGrafo(int anno){
		grafo=new SimpleDirectedGraph<Exhibitions,DefaultEdge>(DefaultEdge.class);
        Graphs.addAllVertices(grafo,ad.listExhibitionsFromYear(anno));
       
       List<Coppia>coppia=new ArrayList<Coppia>();
       coppia=ad.getAdiacenti(anno);
      
       for(int i=0;i<coppia.size();i++){
    	   grafo.addEdge(coppia.get(i).getE1(), coppia.get(i).getE2());
       }

	}
	public Exhibitions getMax(int anno){
		return ad.getMax(anno);
	}
	
	

}
