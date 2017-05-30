package fr.univnantes.julestar.tokensner;

import fr.univnantes.julestar.uima.resources.MapResource;
import fr.univnantes.lina.uima.tkregex.matchers.CoveredTextMatcher;

public class IsInPersonTitlesLexicon extends CoveredTextMatcher {
	private MapResource titles;
	
	public IsInPersonTitlesLexicon(MapResource titles) {
		super();
		this.titles = titles;
	}
	
	@Override
	protected boolean match(String text) {
		return titles.getValueUnchecked(text) != null;
	}
}
