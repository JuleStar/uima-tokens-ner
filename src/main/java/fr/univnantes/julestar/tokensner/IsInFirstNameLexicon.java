package fr.univnantes.julestar.tokensner;

import fr.univnantes.julestar.uima.resources.SetResource;
import fr.univnantes.lina.uima.tkregex.matchers.CoveredTextMatcher;

public class IsInFirstNameLexicon extends CoveredTextMatcher {
	private SetResource firstNames;
	
	public IsInFirstNameLexicon(SetResource firstNames) {
		super();
		this.firstNames = firstNames;
	}
	
	@Override
	protected boolean match(String text) {
		return firstNames.containsValue(text.toLowerCase());
	}
}
