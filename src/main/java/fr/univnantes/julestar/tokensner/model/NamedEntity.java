

/* First created by JCasGen Tue May 30 11:22:06 CEST 2017 */
package fr.univnantes.julestar.tokensner.model;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue May 30 11:22:06 CEST 2017
 * XML source: /home/cram-d/tmp/uima-tokens-ner/src/main/resources/TokensNER_TS.xml
 * @generated */
public class NamedEntity extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NamedEntity.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected NamedEntity() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public NamedEntity(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public NamedEntity(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public NamedEntity(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: neType

  /** getter for neType - gets 
   * @generated
   * @return value of the feature 
   */
  public String getNeType() {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_neType == null)
      jcasType.jcas.throwFeatMissing("neType", "fr.univnantes.julestar.tokensner.model.NamedEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_neType);}
    
  /** setter for neType - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setNeType(String v) {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_neType == null)
      jcasType.jcas.throwFeatMissing("neType", "fr.univnantes.julestar.tokensner.model.NamedEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_neType, v);}    
   
    
  //*--------------*
  //* Feature: pattern

  /** getter for pattern - gets The list of regex matcher labels (e.g. [N, A, A, C, A] )
   * @generated
   * @return value of the feature 
   */
  public String getPattern() {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_pattern == null)
      jcasType.jcas.throwFeatMissing("pattern", "fr.univnantes.julestar.tokensner.model.NamedEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_pattern);}
    
  /** setter for pattern - sets The list of regex matcher labels (e.g. [N, A, A, C, A] ) 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPattern(String v) {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_pattern == null)
      jcasType.jcas.throwFeatMissing("pattern", "fr.univnantes.julestar.tokensner.model.NamedEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_pattern, v);}    
   
    
  //*--------------*
  //* Feature: ruleName

  /** getter for ruleName - gets The unique name of the spotting rule matched
   * @generated
   * @return value of the feature 
   */
  public String getRuleName() {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_ruleName == null)
      jcasType.jcas.throwFeatMissing("ruleName", "fr.univnantes.julestar.tokensner.model.NamedEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_ruleName);}
    
  /** setter for ruleName - sets The unique name of the spotting rule matched 
   * @generated
   * @param v value to set into the feature 
   */
  public void setRuleName(String v) {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_ruleName == null)
      jcasType.jcas.throwFeatMissing("ruleName", "fr.univnantes.julestar.tokensner.model.NamedEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_ruleName, v);}    
  }

    