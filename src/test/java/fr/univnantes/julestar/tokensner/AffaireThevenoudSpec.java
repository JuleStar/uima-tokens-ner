package fr.univnantes.julestar.tokensner;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.cas.CASRuntimeException;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import fr.univnantes.julestar.uima.testing.UIMATest;
import fr.univnantes.termsuite.model.Lang;

public class AffaireThevenoudSpec  {
	
	AnalysisEngine nerEngine;
	
	@Before
	public void setup() throws ResourceInitializationException {
		nerEngine = TokensNERTests.nerEngine(Lang.FR);
	}
	
	
	@Test
	public void test() throws UIMAException, CASRuntimeException, IOException {
		JCas cas = getCAS();
		nerEngine.process(cas);
		UIMATest.assertThat(cas)
			.hasNAnnotationOfType("NamedEntity", 12)
			.containsAnnotation("NamedEntity", 0, 16, "Thomas Thévenoud")
			.containsAnnotation("NamedEntity", 319, 335, "Thomas Thévenoud")
			.containsAnnotation("NamedEntity", 416, 432, "Thomas Thévenoud")
			.containsAnnotation("NamedEntity", 1161, 1177, "Sandra Thévenoud")
			.containsAnnotation("NamedEntity", 1770, 1789, "Léon Schwartzenberg")
			.containsAnnotation("NamedEntity", 1868, 1884, "Thomas Thévenoud")
			.containsAnnotation("NamedEntity", 2476, 2485, "Me Martin")
			.containsAnnotation("NamedEntity", 2479, 2493, "Martin Reynaud")
			.containsAnnotation("NamedEntity", 2608, 2625, "François Hollande")
			.containsAnnotation("NamedEntity", 2705, 2719, "Jérôme Cahuzac")
			.containsAnnotation("NamedEntity", 2721, 2737, "Thomas Thévenoud")
			.containsAnnotation("NamedEntity", 2975, 2989, "Jérôme Cahuzac")
			;
	}



	private JCas getCAS() throws UIMAException, IOException {
		JCas cas = JCasFactory.createJCas();
		Path TEST_FILE = Paths.get("src", "test", "resources", "documents", "affaire-thevenoud.txt");
		cas.setDocumentText(Files.toString(TEST_FILE.toFile(), Charsets.UTF_8));
		return cas;
	}}
