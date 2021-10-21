package fr.eni.GestionPotager.bll.carre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.dal.CarreDAO;

@Service
public class CarreManagerImpl implements CarreManager {

	@Autowired
	private CarreDAO dao;
	
	@Override
	public void addCarre(Carre carre) {
		dao.save(carre);
	}

	@Override
	public void updateCarre(Carre carre) {
		dao.save(carre);
	}

	@Override
	public void deleteCarre(Carre carre) {
		dao.delete(carre);
	}

	@Override
	public List<Carre> getAllCarre() {
		return (List<Carre>) dao.findAll();
	}

}
