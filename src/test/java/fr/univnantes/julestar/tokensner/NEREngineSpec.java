package fr.univnantes.julestar.tokensner;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.junit.Before;
import org.junit.Test;

import fr.univnantes.julestar.uima.testing.UIMATest;
import fr.univnantes.termsuite.model.Lang;

public class NEREngineSpec  {
	
	AnalysisEngine nerEngine;
	
	@Before
	public void setup() throws ResourceInitializationException {
		nerEngine = TokensNERTests.nerEngine(Lang.FR);
	}
	
	@Test
	public void test() throws UIMAException {
		JCas cas = JCasFactory.createJCas();
		cas.setDocumentText("Emmanuel Macron est président.");
		nerEngine.process(cas);
		UIMATest.assertThat(cas)
			.hasNAnnotationOfType("WordAnnotation", 5)
			.hasNAnnotationOfType("NamedEntity", 1)
			.containsAnnotation("WordAnnotation", 0, 8)
			.containsAnnotation("WordAnnotation", 9, 15)
			.containsAnnotation("NamedEntity", 0, 15, "Emmanuel Macron")
			;
	}
}
