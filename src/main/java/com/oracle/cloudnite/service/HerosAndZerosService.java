package com.oracle.cloudnite.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.oracle.cloudnite.model.HerosAndZeros;

@Service
@Repository
public class HerosAndZerosService {
	@PersistenceContext
	private EntityManager entityManager;

	public HashMap<String, List<HerosAndZeros>> getHerosAndZerosData() {
		Query query = entityManager.createNativeQuery("select SVP,REPS,HERO from CLOUD_NITE_SCORECARD");
		List<Object[]> results = query.getResultList();
		HashMap<String, List<HerosAndZeros>> allData = new HashMap<>();
		
		List<HerosAndZeros> heros = new ArrayList<HerosAndZeros>();
		List<HerosAndZeros> zeros = new ArrayList<HerosAndZeros>();
		
		for (int i = 0; i < results.size(); i++) {
			Object[] arr = results.get(i);
			int deals = Integer.parseInt((String)arr[2]);
			String preFormattedSVP = (String) arr[0];
			String svp = preFormattedSVP != null ? preFormattedSVP.trim().replace(".", " "):null;
			String preFormattedReps = (String) arr[1];
			String reps = (preFormattedReps != null ?preFormattedReps.split("@")[0].replace(".", " "):null);
			HerosAndZeros heroAndZeroObj = new HerosAndZeros();
			if(svp.trim().equalsIgnoreCase("mark.dorsey"))
				heroAndZeroObj.setIcon("http://solutionengineering.us.oracle.com:8000/assets/img/Mark_Dorsey_Leaderboard.png");
			else if(svp.trim().equalsIgnoreCase("sherry.lautenbach"))
				heroAndZeroObj.setIcon("http://solutionengineering.us.oracle.com:8000/assets/img/Sherry_Lautenbach_Leaderboard.png");
			else if(svp.trim().equalsIgnoreCase("mark.p.mcnamara"))
				heroAndZeroObj.setIcon("http://solutionengineering.us.oracle.com:8000/assets/img/Mark_McNamara_Leaderboard.png");
			else if(svp.trim().equalsIgnoreCase("chris.gandolfo"))
				heroAndZeroObj.setIcon("http://solutionengineering.us.oracle.com:8000/assets/img/chris_Gandolfo_Leaderboard.png");

			heroAndZeroObj.setNumberOfDeals(deals);
			heroAndZeroObj.setReps(reps);
			heroAndZeroObj.setSvp(svp);
			
			if(deals > 0){
				heros.add(heroAndZeroObj);
			}
			else if(deals == 0){
				zeros.add(heroAndZeroObj);
			}
		}
//		Collections.sort(heros, new Comparator<HerosAndZeros>() {
//			
//			@Override
//			public int compare(HerosAndZeros o1, HerosAndZeros o2) {
//				// TODO Auto-generated method stub
//				return o1.getSvp().compareTo(o2.getSvp());
//			}
//		});	
//		Collections.sort(heros, Comparator.comparing(HerosAndZeros::getSvp)
//				.thenComparing(HerosAndZeros::getNumberOfDeals));
		Collections.sort(heros, new HerosChainedComparator(
				new SvpNameComparator(),
				new DealsComparator()));
		
		Collections.sort(zeros, new HerosChainedComparator(
				new SvpNameComparator(),
				new RepsComparator()));		
		allData.put("heros", heros);
		allData.put("zeros", zeros);
		return allData;
	}

}
