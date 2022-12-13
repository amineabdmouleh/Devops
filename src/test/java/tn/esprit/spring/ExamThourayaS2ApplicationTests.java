package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.VoyageRepository;
import tn.esprit.spring.services.VoyageServiceImpl;

//package tn.esprit.spring;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class ExamThourayaS2ApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

public class ExamThourayaS2ApplicationTests {
	@Mock
	VoyageRepository vr;
	@InjectMocks
	VoyageServiceImpl vs;

	@Test
	public void ajouterVoyageTest() {
		Voyage voyage = new Voyage();

		Mockito.when(vr.save(ArgumentMatchers.any(Voyage.class))).thenReturn(voyage);

		Voyage Voyageadd = vs.ajouterVoyage(voyage);

		assertThat(Voyageadd.getIdVoyage()).isSameAs(Voyageadd.getIdVoyage());
	}

	@Test
	public void recupererAllTest() {
		List<Voyage> voyage = new ArrayList<>();
		voyage.add(new Voyage());

		when(vr.findAll()).thenReturn(voyage);

		List<Voyage> expected = vs.recupererAll();
		
		assertEquals(expected, voyage);
		verify(vr).findAll();
	}

	};

