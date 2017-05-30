package fr.univnantes.julestar.tokensner;

import java.util.List;

import org.apache.uima.jcas.JCas;

import com.google.common.collect.Lists;

import fr.univnantes.julestar.tokensner.model.NamedEntity;

public class NamedEntities {

	public static List<NamedEntity> list(JCas cas) {
		return Lists.newArrayList(cas.getAnnotationIndex(NamedEntity.class));
	}
}
