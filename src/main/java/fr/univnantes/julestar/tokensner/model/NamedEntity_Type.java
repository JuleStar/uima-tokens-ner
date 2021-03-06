
/* First created by JCasGen Tue May 30 14:21:47 CEST 2017 */
package fr.univnantes.julestar.tokensner.model;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Tue May 30 14:21:47 CEST 2017
 * @generated */
public class NamedEntity_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (NamedEntity_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = NamedEntity_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new NamedEntity(addr, NamedEntity_Type.this);
  			   NamedEntity_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new NamedEntity(addr, NamedEntity_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = NamedEntity.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("fr.univnantes.julestar.tokensner.model.NamedEntity");
 
  /** @generated */
  final Feature casFeat_neType;
  /** @generated */
  final int     casFeatCode_neType;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getNeType(int addr) {
        if (featOkTst && casFeat_neType == null)
      jcas.throwFeatMissing("neType", "fr.univnantes.julestar.tokensner.model.NamedEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_neType);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setNeType(int addr, String v) {
        if (featOkTst && casFeat_neType == null)
      jcas.throwFeatMissing("neType", "fr.univnantes.julestar.tokensner.model.NamedEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_neType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_pattern;
  /** @generated */
  final int     casFeatCode_pattern;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getPattern(int addr) {
        if (featOkTst && casFeat_pattern == null)
      jcas.throwFeatMissing("pattern", "fr.univnantes.julestar.tokensner.model.NamedEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_pattern);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPattern(int addr, String v) {
        if (featOkTst && casFeat_pattern == null)
      jcas.throwFeatMissing("pattern", "fr.univnantes.julestar.tokensner.model.NamedEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_pattern, v);}
    
  
 
  /** @generated */
  final Feature casFeat_ruleName;
  /** @generated */
  final int     casFeatCode_ruleName;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getRuleName(int addr) {
        if (featOkTst && casFeat_ruleName == null)
      jcas.throwFeatMissing("ruleName", "fr.univnantes.julestar.tokensner.model.NamedEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_ruleName);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRuleName(int addr, String v) {
        if (featOkTst && casFeat_ruleName == null)
      jcas.throwFeatMissing("ruleName", "fr.univnantes.julestar.tokensner.model.NamedEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_ruleName, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public NamedEntity_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_neType = jcas.getRequiredFeatureDE(casType, "neType", "uima.cas.String", featOkTst);
    casFeatCode_neType  = (null == casFeat_neType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_neType).getCode();

 
    casFeat_pattern = jcas.getRequiredFeatureDE(casType, "pattern", "uima.cas.String", featOkTst);
    casFeatCode_pattern  = (null == casFeat_pattern) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pattern).getCode();

 
    casFeat_ruleName = jcas.getRequiredFeatureDE(casType, "ruleName", "uima.cas.String", featOkTst);
    casFeatCode_ruleName  = (null == casFeat_ruleName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ruleName).getCode();

  }
}



    