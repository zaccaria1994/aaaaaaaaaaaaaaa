package it.polito.tdp.artsmia.db;

import java.util.List;

import it.polito.tdp.artsmia.model.ArtObject;

public class TestArtsmiaDAO {

	public static void main(String[] args) {
		
		ArtsmiaDAO dao = new ArtsmiaDAO() ;
		
		List<ArtObject> objects = dao.listObject() ;
		System.out.println(objects.size());

	}

}
