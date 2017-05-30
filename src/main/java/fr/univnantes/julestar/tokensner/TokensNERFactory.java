package fr.univnantes.julestar.tokensner;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.ExternalResourceFactory;
import org.apache.uima.resource.ExternalResourceDescription;

import com.google.common.base.Preconditions;

import fr.univnantes.julestar.uima.resources.MapResource;
import fr.univnantes.julestar.uima.resources.SetResource;
import fr.univnantes.lina.uima.tkregex.ae.RegexListResource;
import fr.univnantes.lina.uima.tkregex.ae.TokenRegexAE;
import fr.univnantes.termsuite.model.Lang;
import fr.univnantes.termsuite.uima.PreparationPipelineException;
import fr.univnantes.termsuite.uima.TermSuiteResourceException;

public class TokensNERFactory {

	private static URL checkUrl(URL url) {
		Preconditions.checkNotNull(url, "Failed to load resource. Url is null.");
		try(InputStream is = url.openStream()) {
			Preconditions.checkNotNull(is, "Failed to load resource. Got a null input stream for url %s",
					url);
			return url;
		} catch(IOException e) {
			throw new TermSuiteResourceException(
					String.format("Cannot open stream for url %s", url), 
					e);
		}
	}

	public static URL getResource(Lang lang, String suffix) {
		String relativePath = "/" + lang.getCode() + "/"+lang.getName().toLowerCase()+suffix;
		URL resourceURL = TokensNERFactory.class.getResource(relativePath);
		checkUrl(resourceURL);
		return resourceURL;
	}
		
	
	public static AnalysisEngineDescription createPersonNEREngine(Lang lang) {
		
		try {
			AnalysisEngineDescription ae = AnalysisEngineFactory.createEngineDescription(
					PersonNEREngine.class,
					TokenRegexAE.PARAM_ALLOW_OVERLAPPING_OCCURRENCES, false
				);
			
			ExternalResourceDescription rules = ExternalResourceFactory.createExternalResourceDescription(
					RegexListResource.class, 
					getResource(lang, "-persons-ne.regex")
					);
			
			ExternalResourceFactory.bindResource(
					ae,
					RegexListResource.KEY_TOKEN_REGEX_RULES, 
					rules
				);

			ExternalResourceDescription titles = ExternalResourceFactory.createExternalResourceDescription(
					MapResource.class, 
					getResource(lang, "-titles.txt")
					);

			ExternalResourceFactory.bindResource(
					ae,
					PersonNEREngine.RES_TITLES, 
					titles
				);

			ExternalResourceDescription firstNames = ExternalResourceFactory.createExternalResourceDescription(
					SetResource.class, 
					getResource(lang, "-first-names.txt")
					);

			ExternalResourceFactory.bindResource(
					ae,
					PersonNEREngine.RES_FIRST_NAMES, 
					firstNames
				);

			return ae;
		} catch (Exception e) {
			throw new PreparationPipelineException(e);
		}
	}
}
