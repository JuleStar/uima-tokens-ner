package fr.univnantes.julestar.tokensner;

import static java.util.stream.Collectors.joining;

import org.apache.uima.UimaContext;
import org.apache.uima.fit.descriptor.ExternalResource;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import fr.univnantes.julestar.tokensner.model.NamedEntity;
import fr.univnantes.julestar.uima.resources.MapResource;
import fr.univnantes.julestar.uima.resources.SetResource;
import fr.univnantes.lina.uima.tkregex.RegexOccurrence;
import fr.univnantes.lina.uima.tkregex.ae.TokenRegexAE;

public class PersonNEREngine extends TokenRegexAE {
	// resources
	public static final String RES_FIRST_NAMES = "FirstNames";
	@ExternalResource(key = RES_FIRST_NAMES)
	private SetResource firstNames;
	
	// resources
	public static final String RES_TITLES = "Titles";
	@ExternalResource(key = RES_TITLES)
	private MapResource titles;

	@Override
	public void initialize(UimaContext context) throws ResourceInitializationException {
		super.initialize(context);
		registerBuiltinMatcher(IsInFirstNameLexicon.class.getSimpleName(), new IsInFirstNameLexicon(firstNames));
		registerBuiltinMatcher(IsInPersonTitlesLexicon.class.getSimpleName(), new IsInPersonTitlesLexicon(titles));
	}
	
	private static final String TYPE_PERSON = "Person";

	@Override
	protected void ruleMatched(JCas cas, RegexOccurrence occ) {
		String pattern = occ.getLabels().stream().collect(joining(" "));
		String ruleName = occ.getRule().getName();
		NamedEntity annotation = (NamedEntity) cas
				.getCas().createAnnotation(
						cas.getCasType(NamedEntity.type),
						occ.getBegin(),
						occ.getEnd());
		annotation.setPattern(pattern);
		annotation.setNeType(TYPE_PERSON);
		annotation.setRuleName(ruleName);
		cas.addFsToIndexes(annotation);
	}
}
