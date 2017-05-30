package fr.univnantes.julestar.tokensner;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.resource.ResourceInitializationException;

import com.google.common.base.Preconditions;

import fr.univnantes.termsuite.model.Lang;
import fr.univnantes.termsuite.uima.TermSuiteAEFactory;

public class TokensNERTests {

	private static final String TESTS_CONFIG = "termsuite-test.properties";

	public static Path getTreeTaggerPath() {
		return Paths.get((String)getConfigProperty("treetagger.home.path"));
	}

	private static Object getConfigProperty( String propName) {
		InputStream is = TokensNERTests.class.getClassLoader().getResourceAsStream(TESTS_CONFIG);
		Properties properties = new Properties();
		try {
			properties.load(is);
			is.close();
			Preconditions.checkArgument(!properties.contains(propName), "No such property in config file %s: %s", TESTS_CONFIG, propName);
			return properties.get(propName);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public static AnalysisEngine nerEngine(Lang lang) {
		AnalysisEngineDescription tokenizerAE = TermSuiteAEFactory.createWordTokenizerAEDesc(lang);
		AnalysisEngineDescription personAE = TokensNERFactory.createPersonNEREngine(lang);
		AnalysisEngineDescription ae;
		try {
			ae = AnalysisEngineFactory.createEngineDescription(
					tokenizerAE,
					personAE);
		
			return UIMAFramework.produceAnalysisEngine(ae);
		} catch (ResourceInitializationException e) {
			throw new RuntimeException(e);
		}
	}
}
